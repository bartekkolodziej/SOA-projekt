package ejb.implementation;

import dao.UserDAO;
import ejb.dto.User;
import ejb.exceptions.InvalidLoginCredentialsException;
import ejb.interfaces.UserManager;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Random;

@Stateless
public class UserManagerBean implements UserManager {

    public User getUser(Integer userId) {
        return UserDAO.getInstance().getItem(userId);
    }

    public User getUser(String login) {
        List<User> users = UserDAO.getInstance().getItems();

        for (User user : users) {
            if (user.getLogin().equals(login))
                return user;
        }

        return null;
    }

    public User loginUser(String login, String password) {
        User user = this.getUser(login);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    public User createUser(User user) {
        Random generator = new Random();
        user.setId(generator.nextInt(999999)); //TODO - zrobic automatyczne generowanie ID dla kazdej klasy
        UserDAO.getInstance().addItem(user);
        return user;
    }
}
