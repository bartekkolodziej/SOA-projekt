package controllers;

import dao.OrderDAO;
import dao.SubscriptionDAO;
import dao.UserDAO;
import ejb.dto.Order;
import ejb.dto.Subscription;
import ejb.dto.User;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "ApplicationController")
public class ApplicationController implements Serializable {

    private static ApplicationController instance;

    public static ApplicationController getInstance() {
        if (instance == null) {
            instance = new ApplicationController();
        }
        return instance;
    }

    private User loggedUser;

    private List<Order> orders = null;

    private List<Subscription> subscriptions = null;

    private int finalBill;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    private String loginAndRegistrationStatus;

    public String getLoginAndRegistrationStatus() {
        return loginAndRegistrationStatus;
    }

    public void setLoginAndRegistrationStatus(String loginAndRegistrationStatus) {
        this.loginAndRegistrationStatus = loginAndRegistrationStatus;
    }

    public String logout() {
        this.loggedUser = null;
        setLoginAndRegistrationStatus("");
        return "menu?faces-redirect=true";
    }


    public void updateUserOrderList() {
        instance.getLoggedUser().setOrders(UserDAO.getInstance().getItem(instance.loggedUser.getId()).getOrders());
    }

    public String updateOrderList() {
        this.orders = OrderDAO.getInstance().getItems();
        return "userProfile?faces-redirect=true";
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void updateUserSubscriptionsList() {
        instance.getLoggedUser().setSubscriptions(UserDAO.getInstance().getItem(instance.loggedUser.getId()).getSubscriptions());
    }

    public String updateSubscriptionsList() {
        this.subscriptions = SubscriptionDAO.getInstance().getItems();
        return "userProfile?faces-redirect=true";
    }

    public int getFinalBill() {
        finalBill = 0;
        ApplicationController.getInstance().loggedUser.getOrders().forEach( e -> finalBill += e.getPrice());
        return finalBill;
    }

    public void setFinalBill(int finalBill) {
        this.finalBill = finalBill;
    }
}