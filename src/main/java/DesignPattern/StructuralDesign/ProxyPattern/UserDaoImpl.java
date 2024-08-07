package DesignPattern.StructuralDesign.ProxyPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class UserDaoImpl implements IUserDao {
    @Override
    public void addUser(String username) {
        System.out.println("User '" + username + "' added to the database");
    }

    @Override
    public void deleteUser(String username) {
        System.out.println("User '" + username + "' deleted from the database");
    }
}