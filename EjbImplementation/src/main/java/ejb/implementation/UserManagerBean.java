package ejb.implementation;

import dao.UserDAO;
import ejb.dto.User;
import ejb.exceptions.InvalidLoginCredentialsException;
import ejb.interfaces.UserManager;

import javax.ejb.Stateless;

@Stateless
public class UserManagerBean implements UserManager {

    public UserManagerBean() {
    }

    public User getUser(Integer userId) {
        return UserDAO.getInstance().getItem(userId);
    }

    public User loginUser(String username, String password) throws InvalidLoginCredentialsException {
        return null;
    }

    public void createUser(String login, String password, String name, String surname, String role) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setRole(role);
        UserDAO.getInstance().addItem(user);
    }
}
