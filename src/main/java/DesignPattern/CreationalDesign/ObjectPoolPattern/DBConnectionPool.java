package DesignPattern.CreationalDesign.ObjectPoolPattern;

import java.io.Serializable;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class DBConnectionPool {
    private static DBConnectionPool instance;
    private Queue<DBConnection> availableConnections;
    private int maxSize;

    // Private constructor to prevent instantiation
    private DBConnectionPool(int maxSize, String connectionString) {
        this.maxSize = maxSize;
        this.availableConnections = new LinkedBlockingQueue<>(maxSize);

        // Initialize the pool with a few connections
        for (int i = 0; i < maxSize / 2; i++) {
            availableConnections.add(new DBConnection(connectionString));
        }
    }

    // Public method to provide access to the singleton instance
    public static DBConnectionPool getInstance(int maxSize, String connectionString) {
        if (instance == null) {
            synchronized (DBConnectionPool.class) {
                if (instance == null) {
                    instance = new DBConnectionPool(maxSize, connectionString);
                }
            }
        }
        return instance;
    }

    // Synchronized method to get a connection from the pool
    public synchronized DBConnection getConnection() throws InterruptedException {
        if (availableConnections.isEmpty() && availableConnections.size() < maxSize) {
            // Create a new connection if the pool is not full
            availableConnections.add(new DBConnection("jdbc:your_connection_string_here"));
        }
        return availableConnections.poll();
    }

    // Synchronized method to release a connection back to the pool
    public synchronized void releaseConnection(DBConnection connection) {
        if (connection != null) {
            availableConnections.offer(connection);
        }
    }

    // Synchronized method to shut down the connection pool
    public synchronized void shutdown() {
        for (DBConnection connection : availableConnections) {
            connection.close();
        }
    }
}
