package controllers;

import ejb.dto.User;
import ejb.exceptions.InvalidLoginCredentialsException;
import ejb.implementation.UserManagerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@SessionScoped
@ManagedBean(name = "UserController")
public class UserController implements Serializable {


    private UserManagerBean userManagerBean = new UserManagerBean();

    private User user = new User();

    private String action;

    private List<String> roles = Arrays.asList("admin", "client", "manager", "staff", "supplier");

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String register() throws InvalidLoginCredentialsException {
        User registeredUser  = this.userManagerBean.createUser(this.user);
        if (registeredUser != null) {
            ApplicationController.getInstance().setLoggedUser(registeredUser);
            ApplicationController.getInstance().setLoginAndRegistrationStatus("Logged correctly as: " + user.getLogin());
            return "menu?faces-redirect=true";
        } else {
            ApplicationController.getInstance().setLoginAndRegistrationStatus("Something went wrong");
            return "addUser?faces-redirect=true";
        }
    }

    public String login() throws InvalidLoginCredentialsException {
        User loggedUser = this.userManagerBean.loginUser(this.user.getLogin(), this.user.getPassword());
        if(loggedUser != null){
            ApplicationController.getInstance().setLoggedUser(loggedUser);
            ApplicationController.getInstance().setLoginAndRegistrationStatus("Logged correctly as: " + loggedUser.getLogin() +"(" + loggedUser.getRole()+")");
            return "menu?faces-redirect=true";
        } else {
            ApplicationController.getInstance().setLoginAndRegistrationStatus("Invalid login or password");
            return "addUser?faces-redirect=true";
        }
    }

    public String redirectToUserPage(String action) {
        this.action = action;
        return "addUser?faces-redirect=true";
    }

    public String redirectToUserProfile() {
        return "userProfile?faces-redirect=true";
    }
}
