package controllers;

import dao.BillDAO;
import dao.OrderDAO;
import dao.UserDAO;
import ejb.dto.Bill;
import ejb.dto.Order;
import ejb.dto.User;
import org.w3c.dom.UserDataHandler;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
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
}