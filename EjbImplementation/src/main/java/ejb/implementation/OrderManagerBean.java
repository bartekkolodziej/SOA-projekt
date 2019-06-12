package ejb.implementation;

import dao.OrderDAO;
import ejb.dto.Dish;
import ejb.dto.Order;
import ejb.dto.OrderedDish;
import ejb.dto.User;
import ejb.interfaces.OrderManager;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class OrderManagerBean implements OrderManager {

    public List<Order> getOrders() {
        return OrderDAO.getInstance().getItems();
    }

    public Order getOrder(int orderId) {
        return OrderDAO.getInstance().getItem(orderId);
    }

    public Order addOrder(List<OrderedDish> orderedDish, User customer, Date orderDate, Date finalisationDate, String status, Integer price) {
        Order order = new Order();
        Random generator = new Random();
        order.setId(generator.nextInt(999999));
        order.setOrderedDishes(orderedDish);
        order.setCustomer(customer);
        order.setOrderDate(orderDate);
        order.setFinalisationDate(finalisationDate);
        order.setStatus(status);
        order.setPrice(price);
        OrderDAO.getInstance().addItem(order);
        return order;
    }
}
