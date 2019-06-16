package controllers;

import dao.OrderDAO;
import dao.OrderedDishDAO;
import dao.SubscriptionDAO;
import dao.UserDAO;
import ejb.dto.*;
import ejb.exceptions.InvalidLoginCredentialsException;
import ejb.implementation.UserManagerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SessionScoped
@ManagedBean(name = "UserController")
public class UserController implements Serializable {


    private UserManagerBean userManagerBean = new UserManagerBean();

    private User user = new User();

    private String password;

    private String action;

    private List<String> roles = Arrays.asList("client", "manager", "staff", "supplier");

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
        if(user.getRole() == null)
            user.setRole("client");

        user.setPassword(password.hashCode());
        User registeredUser  = userManagerBean.createUser(user);

        if (registeredUser != null) {
            ApplicationController.getInstance().setLoggedUser(registeredUser);
            ApplicationController.getInstance().setLoginAndRegistrationStatus("Logged correctly as: " + user.getLogin());
            return "index?faces-redirect=true";
        } else {
            ApplicationController.getInstance().setLoginAndRegistrationStatus("Something went wrong");
            return "addUser?faces-redirect=true";
        }
    }

    public String login() throws InvalidLoginCredentialsException {
        User loggedUser = userManagerBean.loginUser(user.getLogin(), password);
        if(loggedUser != null){
            ApplicationController.getInstance().setLoggedUser(loggedUser);
            ApplicationController.getInstance().setLoginAndRegistrationStatus("Logged correctly as: " + loggedUser.getLogin() +"(" + loggedUser.getRole()+")");
            return "index?faces-redirect=true";
        } else {
            ApplicationController.getInstance().setLoginAndRegistrationStatus("Invalid login or password");
            return "addUser?faces-redirect=true";
        }
    }

    public String redirectToUserPage(String action) {
        this.action = action;
        if(action.equals("login"))
            ApplicationController.getInstance().setLoginAndRegistrationStatus("");
        return "addUser?faces-redirect=true";
    }

    public String redirectToUserProfile() {
        if(ApplicationController.getInstance().getLoggedUser().getRole().equals("client")) {
            ApplicationController.getInstance().updateUserOrderList();
            ApplicationController.getInstance().updateUserSubscriptionsList();
        }
        else {
            ApplicationController.getInstance().updateOrderList();
            ApplicationController.getInstance().updateSubscriptionsList();
        }
        return "userProfile?faces-redirect=true";
    }

    public void setOrderStatus(Order order, String status){
        order.setStatus(status);
        if(status.equals("delivered"))
            order.setFinalisationDate(new Date());
        OrderDAO.getInstance().updateItem(order);
    }

    public void removeDishFromDB(Order order, OrderedDish orderedDish){
        order.getOrderedDishes().remove(orderedDish);
        order.setPrice(order.getPrice() - orderedDish.getDish().getPrice());
        OrderedDishDAO.getInstance().deleteItem(orderedDish.getId());
        OrderDAO.getInstance().updateItem(order);
    }

    public void removeDishFromDB(Subscription subscription, OrderedDish orderedDish){
        subscription.getDishes().remove(orderedDish);
        OrderedDishDAO.getInstance().deleteItem(orderedDish.getId());
        SubscriptionDAO.getInstance().updateItem(subscription);
    }

    public void removeOrderFromDB(Order order){
       OrderDAO.getInstance().deleteItem(order.getId());
        ApplicationController.getInstance().updateUserOrderList();
        ApplicationController.getInstance().updateOrderList();
    }

    public void removeSubscriptionFromDB(Subscription subscription){
        SubscriptionDAO.getInstance().deleteItem(subscription.getId());
        ApplicationController.getInstance().updateUserSubscriptionsList();
        ApplicationController.getInstance().updateSubscriptionsList();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
