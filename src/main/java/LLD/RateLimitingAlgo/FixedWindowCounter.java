package LLD.RateLimitingAlgo;

import java.time.Instant;

/**
 * @author : Kunal Sharma
 * @since : 02/08/24, Friday
 **/
public class FixedWindowCounter {


    private final long windowSizeInSeconds;  // Size of each window in seconds
    private final long maxRequestsPerWindow; // Maximum number of requests allowed per window
    private long currentWindowStart;         // Start time of the current window
    private long requestCount;               // Number of requests in the current window

    public FixedWindowCounter(long windowSizeInSeconds, long maxRequestsPerWindow) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.maxRequestsPerWindow = maxRequestsPerWindow;
        this.currentWindowStart = Instant.now().getEpochSecond();
        this.requestCount = 0;
    }

    public synchronized boolean allowRequest() {
        long now = Instant.now().getEpochSecond();

        // Check if we've moved to a new window
        if (now - currentWindowStart >= windowSizeInSeconds) {
            currentWindowStart = now; // Start a new window
            requestCount = 0;  // Reset the count for the new window
        }

        if (requestCount < maxRequestsPerWindow) {
            requestCount++; // Increment the count for this window
            return true; // Allow the request
        }
        return false; // We've exceeded the limit for this window, deny the request
    }

    public static void main(String[] args) {
        FixedWindowCounter counter = new FixedWindowCounter(10, 3); // 3 requests per 10 seconds

        // Simulate requests
        for (int i = 0; i < 5; i++) {
            if (counter.allowRequest()) {
                System.out.println("Request " + i + " allowed");
            } else {
                System.out.println("Request " + i + " denied");
            }
            try {
                Thread.sleep(2000); // Simulate 2 seconds delay between requests
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}