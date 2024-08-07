package DesignPattern.StructuralDesign.ProxyPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class UserDaoProxy implements IUserDao {
    private IUserDao userDao;

    @Override
    public void addUser(String username) {
        lazyInit();
        userDao.addUser(username);
    }

    @Override
    public void deleteUser(String username) {
        lazyInit();
        userDao.deleteUser(username);
    }

    private void lazyInit() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
    }
}
