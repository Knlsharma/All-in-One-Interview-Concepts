package DesignPattern.CreationalDesign.ObjectPoolPattern;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class DBConnection {
    private String connectionString;

    public DBConnection(String connectionString) {
        this.connectionString = connectionString;
        // Simulate opening a connection (this is just for demonstration)
        System.out.println("Opening connection to " + connectionString);
    }

    public void executeQuery(String query) {
        // Simulate executing a query
        System.out.println("Executing query: " + query + " on connection: " + connectionString);
    }

    public void close() {
        // Simulate closing a connection (this is just for demonstration)
        System.out.println("Closing connection to " + connectionString);
    }
}
