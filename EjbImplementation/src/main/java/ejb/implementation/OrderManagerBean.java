package ejb.implementation;

import dao.OrderDAO;
import ejb.dto.Dish;
import ejb.dto.Order;
import ejb.dto.User;
import ejb.interfaces.OrderManager;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class OrderManagerBean implements OrderManager {

    @Override
    public List<Order> getOrders() {
        return OrderDAO.getInstance().getItems();
    }

    @Override
    public Order getOrder(int orderId) {
        return OrderDAO.getInstance().getItem(orderId);
    }

    @Override
    public Order addOrder(List<Dish> dishes, User customer, Date orderDate, Date finalisationDate, String status, Integer price) {
        Order order = new Order();
        Random generator = new Random();
        order.setId(generator.nextInt(999999));
        order.setOrderedDishes(dishes);
        order.setCustomer(customer);
        order.setorderDate(orderDate);
        order.setfinalisationDate(finalisationDate);
        order.setStatus(status);
        order.setPrice(price);
        OrderDAO.getInstance().addItem(order);
        return order;
    }
}
