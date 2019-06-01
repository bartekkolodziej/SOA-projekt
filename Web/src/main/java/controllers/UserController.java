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

    private String login;

    private String password;

    private String name;

    private String surname;

    private String role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void register() throws InvalidLoginCredentialsException {
        //System.out.println(this.user);
        this.userManagerBean.createUser(login, password, name, surname, role);
    }
}
