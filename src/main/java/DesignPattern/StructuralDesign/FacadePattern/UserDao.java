package DesignPattern.StructuralDesign.FacadePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public interface UserDao {
    User getUserById(int id);
    void saveUser(User user);
    void deleteUser(int id);
}
