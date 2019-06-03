package ejb.implementation;

import dao.UserDAO;
import ejb.dto.User;
import ejb.exceptions.InvalidLoginCredentialsException;
import ejb.interfaces.UserManager;

import javax.ejb.Stateless;
import java.util.Random;

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
        Random generator = new Random();
        user.setId(generator.nextInt(999999)); //TODO - zrobic automatyczne generowanie ID dla kazdej klasy
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setRole(role);
        UserDAO.getInstance().addItem(user);
    }
}
