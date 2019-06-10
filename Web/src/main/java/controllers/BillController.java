package controllers;

import dao.BillDAO;
import dao.UserDAO;
import ejb.dto.Bill;
import ejb.dto.Dish;
import ejb.dto.Order;
import ejb.dto.User;
import ejb.implementation.BillManagerBean;
import ejb.implementation.OrderManagerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SessionScoped
@ManagedBean(name = "BillController")
public class BillController implements Serializable {

    private BillManagerBean billManagerBean = new BillManagerBean();

    private OrderManagerBean orderManagerBean = new OrderManagerBean();


    private int finalValue = 0;

    private List<Dish> dishesInCart = new ArrayList<>();

    public List<Dish> getDishesInCart() {
        return dishesInCart;
    }

    public void setDishesInCart(List<Dish> dishesInCart) {
        this.dishesInCart = dishesInCart;
    }

    public void setFinalValue(int finalValue) {
        this.finalValue = finalValue;
    }

    public int getFinalValue() {
        return finalValue;
    }

    public void addDishToCart(Dish dish) {
        this.dishesInCart.add(dish);
        this.finalValue += dish.getPrice();
    }

    public void order() {
        Order order = orderManagerBean.addOrder(this.dishesInCart, ApplicationController.getInstance().getLoggedUser(), new Date(), null, "inProgress", this.finalValue);
        List<Order> orders = Arrays.asList(order);
        this.billManagerBean.addBill(ApplicationController.getInstance().getLoggedUser(), finalValue, orders);
        ApplicationController.getInstance().getLoggedUser().setOrders(orders);
        UserDAO.getInstance().updateItem(ApplicationController.getInstance().getLoggedUser());
        this.finalValue = 0;
        this.dishesInCart = new ArrayList<>();
    }
}
