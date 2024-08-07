package DesignPattern.CreationalDesign.ObjectPoolPattern;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class Driver {
    public static void main(String[] args) {
        // Get the singleton instance of DBConnectionPool
        DBConnectionPool connectionPool = DBConnectionPool.getInstance(10, "jdbc:your_connection_string_here");

        try {
            // Get a connection from the pool
            DBConnection connection1 = connectionPool.getConnection();
            connection1.executeQuery("SELECT * FROM users");

            // Return the connection to the pool
            connectionPool.releaseConnection(connection1);

            // Get another connection from the pool
            DBConnection connection2 = connectionPool.getConnection();
            connection2.executeQuery("SELECT * FROM products");

            // Return the connection to the pool
            connectionPool.releaseConnection(connection2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the connection pool
            connectionPool.shutdown();
        }
    }
}
