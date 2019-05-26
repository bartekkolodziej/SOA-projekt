package controllers;

import ejb.dto.User;
import ejb.exceptions.InvalidLoginCredentialsException;
import ejb.implementation.UserManagerBean;

import javax.inject.Named;
import java.io.Serializable;

@Named("UserController")
public class UserController implements Serializable {


    private UserManagerBean userManagerBean;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void register() throws InvalidLoginCredentialsException {
        userManagerBean.createUser(user.getLogin(), user.getPassword(), user.getName(), user.getSurname(), user.getRole());
    }
}
