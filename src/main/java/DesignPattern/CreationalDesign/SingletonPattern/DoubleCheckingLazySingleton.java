package DesignPattern.CreationalDesign.SingletonPattern;

import java.io.Serializable;

/**
 * @author Kunal Sharma at 09/05/22 1:01 PM
 */
public class DoubleCheckingLazySingleton extends MyClone implements Serializable {
    private static DoubleCheckingLazySingleton instance;
    private DoubleCheckingLazySingleton() {
        if (instance != null) {  // 2.) to prevent reflection
            throw new IllegalStateException("object can't be create using reflection");
        }
    }


    public static DoubleCheckingLazySingleton getInstance() {    // Remove synchronized at method level
        if (instance == null) {
            synchronized (DoubleCheckingLazySingleton.class) {
                if (instance == null) { // Only 1 allowed
                    instance = new DoubleCheckingLazySingleton();
                }
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {  // 1.) to prevent cloning
        throw new CloneNotSupportedException();
    }


    protected Object readResolve() {
        return instance;
    }  // 3 .) to prevent from serialization
}
