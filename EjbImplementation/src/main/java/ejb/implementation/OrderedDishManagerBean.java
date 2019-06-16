package ejb.implementation;

import dao.OrderedDishDAO;
import ejb.dto.Dish;
import ejb.dto.Order;
import ejb.dto.OrderedDish;
import ejb.dto.Subscription;
import ejb.interfaces.OrderedDishManager;

import java.util.List;

public class OrderedDishManagerBean implements OrderedDishManager {
    public List<OrderedDish> getOrderedDishes() {
        return OrderedDishDAO.getInstance().getItems();
    }

    public OrderedDish addOrderedDish(Dish dish, Order order) {
        OrderedDish orderedDish = new OrderedDish();
        orderedDish.setDish(dish);
        orderedDish.setOrder(order);
        OrderedDishDAO.getInstance().addItem(orderedDish);
        return orderedDish;
    }

    public OrderedDish addOrderedDish(Dish dish, Subscription subscription) {
        OrderedDish orderedDish = new OrderedDish();
        orderedDish.setDish(dish);
        orderedDish.setSubscription(subscription);
        OrderedDishDAO.getInstance().addItem(orderedDish);
        return orderedDish;
    }
}