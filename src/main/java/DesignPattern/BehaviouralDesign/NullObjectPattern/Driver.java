package DesignPattern.BehaviouralDesign.NullObjectPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {
        // Create a Client with ConsoleLogger
        Client client1 = new Client(new ConsoleLogger());
        client1.doSomething(); // Output: Console Logger: Doing something...

        // Create a Client with NullLogger
        Client client2 = new Client(new NullLogger());
        client2.doSomething(); // No output, because NullLogger does nothing
    }
}
