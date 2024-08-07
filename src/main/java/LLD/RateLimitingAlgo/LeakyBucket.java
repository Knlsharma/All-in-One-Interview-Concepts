package LLD.RateLimitingAlgo;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Kunal Sharma
 * @since : 02/08/24, Friday
 **/
public class LeakyBucket {

    private final long capacity;            // Maximum number of requests the bucket can hold
    private final double leakRate;          // Rate at which requests leak out of the bucket (requests per second)
    private final Queue<Instant> bucket;  // Queue to hold timestamps of requests (FIFO)
    private Instant lastLeakTimestamp;      // Last time we leaked from the bucket

    public LeakyBucket(long capacity, double leakRate) {
        if (capacity <= 0 || leakRate <= 0) {
            throw new IllegalArgumentException("Capacity and leakRate must be positive values");
        }
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.bucket = new LinkedList<>();
        this.lastLeakTimestamp = Instant.now();
    }

    public synchronized boolean allowRequest() {
        leak();  // First, leak out any requests based on elapsed time

        if (bucket.size() < capacity) {
            bucket.offer(Instant.now());  // Add the new request to the bucket (FIFO)
            return true;  // Allow the request
        }
        return false;  // Bucket is full, deny the request
    }

    private void leak() {
        Instant now = Instant.now();
        long elapsedMillis = now.toEpochMilli() - lastLeakTimestamp.toEpochMilli();
        int leakedItems = (int) (elapsedMillis * leakRate / 1000.0);  // Calculate how many items should have leaked

        // Remove the leaked items from the bucket (oldest first)
        for (int i = 0; i < leakedItems && !bucket.isEmpty(); i++) {
            bucket.poll();
        }

        lastLeakTimestamp = now;
    }

    public static void main(String[] args) {
        // Example usage
        LeakyBucket bucket = new LeakyBucket(5, 1.0);  // Capacity of 5, leak rate of 1 request/second

        for (int i = 0; i < 10; i++) {
            if (bucket.allowRequest()) {
                System.out.println("Request " + (i + 1) + " allowed");
            } else {
                System.out.println("Request " + (i + 1) + " denied (bucket full)");
            }
            try {
                Thread.sleep(500);  // Simulate requests arriving every 0.5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
