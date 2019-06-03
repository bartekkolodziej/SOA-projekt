package dao;

import ejb.dto.Order;

public class OrderDAO extends AbstractDAO<Order> {
    private static OrderDAO instance;

    public static OrderDAO getInstance() {
        if (instance == null) {
            instance = new OrderDAO();
        }
        return instance;
    }

    private OrderDAO() {
        super(Order.class);
    }
}
