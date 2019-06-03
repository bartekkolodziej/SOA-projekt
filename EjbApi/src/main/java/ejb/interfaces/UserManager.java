package ejb.interfaces;

import ejb.dto.User;
import ejb.exceptions.InvalidLoginCredentialsException;

public interface UserManager {
    User getUser(Integer userId);
    User getUser(String userName);
    User loginUser(String username, String password) throws InvalidLoginCredentialsException;
    void createUser(String login, String password, String name, String surname, String role);
}