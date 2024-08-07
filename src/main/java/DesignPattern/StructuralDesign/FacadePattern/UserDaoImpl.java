package DesignPattern.StructuralDesign.FacadePattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class UserDaoImpl implements UserDao {
    // Simulated database
    private Map<Integer, User> database = new HashMap<>();

    @Override
    public User getUserById(int id) {
        return database.get(id);
    }

    @Override
    public void saveUser(User user) {
        database.put(user.getId(), user);
        System.out.println("User saved: " + user.getUsername());
    }

    @Override
    public void deleteUser(int id) {
        User deletedUser = database.remove(id);
        if (deletedUser != null) {
            System.out.println("User deleted: " + deletedUser.getUsername());
        }
    }
}
