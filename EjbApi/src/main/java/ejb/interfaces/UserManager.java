package ejb.interfaces;

import ejb.dto.User;
import ejb.exceptions.InvalidLoginCredentialsException;

public interface UserManager {
    User getUser(Integer userId);
    User getUser(String userName);
    User loginUser(String login, String password) throws InvalidLoginCredentialsException;
    User createUser(User user);
}