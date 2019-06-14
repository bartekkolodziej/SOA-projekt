package controllers;

import dao.OrderDAO;
import dao.OrderedDishDAO;
import dao.UserDAO;
import ejb.dto.Dish;
import ejb.dto.Menu;
import ejb.dto.Order;
import ejb.dto.OrderedDish;
import ejb.implementation.BillManagerBean;
import ejb.implementation.MenuManagerBean;
import ejb.implementation.OrderManagerBean;
import ejb.implementation.OrderedDishManagerBean;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@javax.faces.bean.ViewScoped
@ManagedBean(name = "IndexController")
public class IndexController implements Serializable {

    private BillManagerBean billManagerBean = new BillManagerBean();
    private OrderManagerBean orderManagerBean = new OrderManagerBean();
    private OrderedDishManagerBean orderedDishManagerBean = new OrderedDishManagerBean();
    private MenuManagerBean menuManagerBean = new MenuManagerBean();

    public IndexController() {
        this.updateMenu();
    }

    private Menu menu;

    private int finalValue = 0;

    private List<Dish> dishesInCart = new ArrayList<>();

    public void updateMenu(){
        this.menu = menuManagerBean.getCurrentMenu();
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

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

    public void removeFromCart(Dish dish){
        this.dishesInCart.remove(dish);
    }

    public void order() {
        List<OrderedDish> orderedDishes = new ArrayList<>();
        for(Dish o : this.dishesInCart ){
            orderedDishes.add(orderedDishManagerBean.addOrderedDish(o, null));
        }
        Order order = orderManagerBean.addOrder(null, ApplicationController.getInstance().getLoggedUser(), new Date(), null, "inProgress", this.finalValue);

        orderedDishes.forEach(e -> {
            e.setOrder(order);
            OrderedDishDAO.getInstance().updateItem(e);
        });

        order.setOrderedDishes(orderedDishes);;
        OrderDAO.getInstance().updateItem(order);

        List<Order> orders = Arrays.asList(order);
        this.billManagerBean.addBill(ApplicationController.getInstance().getLoggedUser(), finalValue, orders);
        ApplicationController.getInstance().getLoggedUser().setOrders(orders);
        UserDAO.getInstance().updateItem(ApplicationController.getInstance().getLoggedUser());

        this.finalValue = 0;
        this.dishesInCart = new ArrayList<>();
        orderedDishes = new ArrayList<>();
    }

}
