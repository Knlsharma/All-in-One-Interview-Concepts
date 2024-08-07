package DesignPattern.CreationalDesign.SingletonPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author Kunal Sharma at 09/05/22 1:02 PM
 */
public class Driver {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Hello World!");

        LazySingleton instance1 = LazySingleton.getInstance();
        //System.out.println(instance1.hashCode());

        // Serialize singleton object to a file.
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        out.writeObject(instance1);
        out.close();

        // Deserialize singleton object from the file
        ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.ser"));
        LazySingleton instance2 = (LazySingleton) in.readObject();
        in.close();

        System.out.println("instance1 hashCode: " + instance1.hashCode());
        System.out.println("instance2 hashCode: " + instance2.hashCode());

        /*
         * LazySingleton reflectionInstance=null;
         *
         *
         * Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
         * for (Constructor constructor : constructors) {
         * constructor.setAccessible(true); reflectionInstance = (LazySingleton)
         * constructor.newInstance(); }
         *
         * System.out.println(reflectionInstance.hashCode());
         */

        /*
         * LazySingleton instance2 = (LazySingleton) instance1.clone();
         *
         * System.out.println(instance2.hashCode());
         */
    }

}
