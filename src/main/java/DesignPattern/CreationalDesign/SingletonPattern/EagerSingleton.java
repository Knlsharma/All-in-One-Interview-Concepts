package DesignPattern.CreationalDesign.SingletonPattern;

/**
 * @author Kunal Sharma at 09/05/22 11:06 AM
 */

public class EagerSingleton {
    private EagerSingleton() {  // 1.)
    }

    private static final EagerSingleton instance = new EagerSingleton();  // 3.)

    public static EagerSingleton getInstance() {  // 2.)
        return instance;
    }

    // memory and resource coupled
    // when a class is loaded, static things also initialized
}
