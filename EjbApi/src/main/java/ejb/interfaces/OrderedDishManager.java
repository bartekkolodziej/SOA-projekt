package ejb.interfaces;

import ejb.dto.Dish;
import ejb.dto.Order;
import ejb.dto.OrderedDish;


import java.util.List;

public interface OrderedDishManager {
    List<OrderedDish> getOrderedDishes();
    void addOrderedDish(Dish dish, Order order);
}
