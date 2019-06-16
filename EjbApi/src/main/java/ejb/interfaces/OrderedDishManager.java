package ejb.interfaces;

import ejb.dto.Dish;
import ejb.dto.Order;
import ejb.dto.OrderedDish;
import ejb.dto.Subscription;


import java.util.List;

public interface OrderedDishManager {
    List<OrderedDish> getOrderedDishes();
    OrderedDish addOrderedDish(Dish dish, Order order);
    OrderedDish addOrderedDish(Dish dish, Subscription subscription);
}