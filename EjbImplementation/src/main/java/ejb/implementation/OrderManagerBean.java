package ejb.implementation;

import dao.OrderDAO;
import ejb.dto.Order;
import ejb.dto.OrderedDish;
import ejb.dto.User;
import ejb.interfaces.OrderManager;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class OrderManagerBean implements OrderManager {

    @Override
    public Order getOrder(int orderId) {
        return null;
    }

    @Override
    public void addOrder(List<OrderedDish> orderedDishes, User customer, Date orderDate, Date finalisationDate, String status, Double price) {
        Order order = new Order();
        Random generator = new Random();
        order.setId(generator.nextInt(999999));
        order.setOrderedDishes(orderedDishes);
        order.setCustomer(customer);
        order.setorderDate(orderDate);
        order.setfinalisationDate(finalisationDate);
        order.setStatus(status);
        order.setPrice(price);
        OrderDAO.getInstance().addItem(order);
    }
}
