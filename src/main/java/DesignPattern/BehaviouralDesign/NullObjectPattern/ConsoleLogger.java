package DesignPattern.BehaviouralDesign.NullObjectPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println("Console Logger: " + message);
    }
}
