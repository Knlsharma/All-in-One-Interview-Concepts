package LLD.RateLimitingAlgo;

import java.time.Instant;

/**
 * @author : Kunal Sharma
 * @since : 02/08/24, Friday
 **/
public class SlidingWindowCounter {
    private final long windowSizeInSeconds;   // Size of the sliding window in seconds
    private final long maxRequestsPerWindow;  // Maximum number of requests allowed in the window
    private long currentWindowStart;          // Start time of the current window
    private long previousWindowCount;         // Number of requests in the previous window
    private long currentWindowCount;          // Number of requests in the current window

    public SlidingWindowCounter(long windowSizeInSeconds, long maxRequestsPerWindow) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.maxRequestsPerWindow = maxRequestsPerWindow;
        this.currentWindowStart = Instant.now().getEpochSecond();
        this.previousWindowCount = 0;
        this.currentWindowCount = 0;
    }

    public synchronized boolean allowRequest() {
        long now = Instant.now().getEpochSecond();
        long timePassedInWindow = now - currentWindowStart;

        // Check if we've moved to a new window
        if (timePassedInWindow >= windowSizeInSeconds) {
            previousWindowCount = currentWindowCount;
            currentWindowCount = 0;
            currentWindowStart = now;
            timePassedInWindow = 0;
        }

        // Calculate the weighted count of requests
        double weightedCount = previousWindowCount * ((windowSizeInSeconds - timePassedInWindow) / (double) windowSizeInSeconds)
                + currentWindowCount;

        if (weightedCount < maxRequestsPerWindow) {
            currentWindowCount++; // Increment the count for this window
            return true; // Allow the request
        }
        return false; // We've exceeded the limit, deny the request
    }

    public static void main(String[] args) {
        SlidingWindowCounter counter = new SlidingWindowCounter(10, 3); // 3 requests per 10 seconds

        // Simulate requests
        for (int i = 0; i < 10; i++) {
            if (counter.allowRequest()) {
                System.out.println("Request " + i + " allowed");
            } else {
                System.out.println("Request " + i + " denied");
            }
            try {
                Thread.sleep(1000); // Simulate 1 second delay between requests
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
