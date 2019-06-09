package ejb.interfaces;

import ejb.dto.Dish;
import ejb.dto.Order;
import ejb.dto.User;

import java.util.Date;
import java.util.List;

public interface OrderManager {

    List<Order> getOrders();
    Order getOrder(int orderId);
    Order addOrder(List<Dish> orderedDishes, User customer, Date orderDate, Date finalisationDate, String status, Integer price);
}
