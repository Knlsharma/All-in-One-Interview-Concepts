package DesignPattern.BehaviouralDesign.NullObjectPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Client {
    private Logger logger;

    // Constructor
    public Client(Logger logger) {
        this.logger = logger;
    }

    public void doSomething() {
        // Using logger without null checks
        logger.log("Doing something...");
    }
}
