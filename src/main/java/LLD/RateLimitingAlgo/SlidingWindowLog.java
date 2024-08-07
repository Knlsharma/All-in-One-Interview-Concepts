package LLD.RateLimitingAlgo;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Kunal Sharma
 * @since : 02/08/24, Friday
 **/
public class SlidingWindowLog {

    private final long windowSizeInSeconds;   // Size of the sliding window in seconds
    private final long maxRequestsPerWindow;  // Maximum number of requests allowed in the window
    private final Queue<Long> requestLog;     // Log of request timestamps

    public SlidingWindowLog(long windowSizeInSeconds, long maxRequestsPerWindow) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.maxRequestsPerWindow = maxRequestsPerWindow;
        this.requestLog = new LinkedList<>();
    }

    public synchronized boolean allowRequest() {
        long now = Instant.now().getEpochSecond();
        long windowStart = now - windowSizeInSeconds;

        // Remove timestamps that are outside of the current window
        while (!requestLog.isEmpty() && requestLog.peek() <= windowStart) {
            requestLog.poll();
        }

        if (requestLog.size() < maxRequestsPerWindow) {
            requestLog.offer(now);  // Log this request
            return true;            // Allow the request
        }
        return false;  // We've exceeded the limit for this window, deny the request
    }

    public static void main(String[] args) {
        SlidingWindowLog counter = new SlidingWindowLog(10, 3); // 3 requests per 10 seconds

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
