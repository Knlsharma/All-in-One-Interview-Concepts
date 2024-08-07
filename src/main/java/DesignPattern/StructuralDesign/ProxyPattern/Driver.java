package DesignPattern.StructuralDesign.ProxyPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {
        // Using the UserDaoImpl directly
        System.out.println("Using UserDaoImpl directly:");
        IUserDao userDaoImpl = new UserDaoImpl();
        userDaoImpl.addUser("Alice");
        userDaoImpl.deleteUser("Alice");

        // Using the UserDaoProxy
        System.out.println("\nUsing UserDaoProxy:");
        IUserDao userDaoProxy = new UserDaoProxy();
        userDaoProxy.addUser("Bob");
        userDaoProxy.deleteUser("Bob");
    }
}
