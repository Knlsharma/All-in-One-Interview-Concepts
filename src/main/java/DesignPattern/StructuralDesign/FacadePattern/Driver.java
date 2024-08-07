package DesignPattern.StructuralDesign.FacadePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {
        UserDaoFacade userDaoFacade = new UserDaoFacade();

        // Save a user
        User user1 = new User(1, "Alice");
        userDaoFacade.saveUser(user1);

        // Retrieve a user by ID
        User retrievedUser = userDaoFacade.getUserById(1);
        if (retrievedUser != null) {
            System.out.println("Retrieved user: " + retrievedUser.getUsername());
        }

        // Delete a user by ID
        userDaoFacade.deleteUser(1);
    }
}
