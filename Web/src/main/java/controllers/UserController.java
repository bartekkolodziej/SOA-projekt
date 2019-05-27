package controllers;

import ejb.dto.User;
import ejb.exceptions.InvalidLoginCredentialsException;
import ejb.implementation.UserManagerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@SessionScoped
@ManagedBean(name = "UserController")
public class UserController implements Serializable {


    private UserManagerBean userManagerBean = new UserManagerBean();

    private User user = new User();

    public String getLogin() {
        return user.getLogin();
    }

    public void setLogin(String login) {
        user.setLogin(login);
    }

    public String getPassword() {
        return user.getPassword();
    }

    public void setPassword(String password) {
        user.setPassword(password);
    }

    public String getName() {
        return user.getName();
    }

    public void setName(String name) {
        user.setName(name);
    }

    public String getSurname() {
        return user.getSurname();
    }

    public void setSurname(String surname) {
        user.setSurname(surname);
    }

    public String getRole() {
        return user.getRole();
    }

    public void setRole(String role) {
        user.setRole(role);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void register() throws InvalidLoginCredentialsException {
        System.out.println(this.user);
        this.userManagerBean.createUser(user.getLogin(), user.getPassword(), user.getName(), user.getSurname(), user.getRole());
    }
}
