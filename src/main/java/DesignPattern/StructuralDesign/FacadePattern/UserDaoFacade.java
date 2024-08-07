package DesignPattern.StructuralDesign.FacadePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class UserDaoFacade {
    private UserDao userDao;

    public UserDaoFacade() {
        this.userDao = new UserDaoImpl(); // Or inject via constructor
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
