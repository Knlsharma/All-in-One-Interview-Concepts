package DesignPattern.CreationalDesign.SingletonPattern;

import java.io.Serializable;

/**
 * @author Kunal Sharma at 09/05/22 1:01 PM
 */
public class LazzyInnerClassSingleton extends MyClone implements Serializable  {

    private static boolean instanceCreated = false;

    private LazzyInnerClassSingleton() {
        if (instanceCreated) {
            throw new RuntimeException("Use getInstance() method to create");
        }
        instanceCreated = true; // to prevent from constructing multiple times
    }

    private static class SingletonHelper {  // static nested inner class
        private static final LazzyInnerClassSingleton instance = new LazzyInnerClassSingleton();
    }

    public static LazzyInnerClassSingleton getInstance() {
        return SingletonHelper.instance;
        // ensures that the static inner class (SingletonHelper) is loaded and
        // initialized only when it is accessed for the first time.
    }

    protected Object readResolve() {
        return getInstance(); // prevent from serialization
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {  // to prevent cloning
        throw new CloneNotSupportedException();
    }

}
