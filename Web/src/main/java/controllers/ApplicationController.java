package controllers;

import dao.BillDAO;
import ejb.dto.Bill;
import ejb.dto.User;

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

    public void getOrders () {
      instance.getLoggedUser().getOrders().forEach(e -> System.out.println(e.getOrderedDishes().get(0).getName())); //TODO - zrobic jakies normalne wyciagnie z bay
    }
}