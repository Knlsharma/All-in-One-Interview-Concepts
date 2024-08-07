package DesignPattern.CreationalDesign.SingletonPattern;

import java.io.Serializable;

/**
 * @author Kunal Sharma at 09/05/22 1:00 PM
 */
public class LazySingleton extends MyClone implements Serializable {
    private static LazySingleton instance = null; // This will load static with null at load time


    private LazySingleton() {
        if (instance != null) {
            throw new IllegalStateException("object can't be create using reflection");
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolve() {
        return instance;
    }

    public static synchronized LazySingleton getInstance() { // solving with synchronized
        if (instance == null) {
            return instance = new LazySingleton();  // 2 object by 2 thread
        } else {
            return instance;
        }
    }
}
