package ejb.interfaces;

import ejb.dto.Order;
import ejb.dto.OrderedDish;
import ejb.dto.User;

import java.util.Date;
import java.util.List;

public interface OrderManager {

    Order getOrder(int orderId);
    void addOrder(List<OrderedDish> orderedDishes, User customer, Date orderDate, Date finalisationDate, String status, Double price);
}
