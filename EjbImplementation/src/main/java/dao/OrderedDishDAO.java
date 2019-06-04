package dao;

import ejb.dto.OrderedDish;

public class OrderedDishDAO extends AbstractDAO<OrderedDish> {
    private static OrderedDishDAO instance;

    public static OrderedDishDAO getInstance() {
        if (instance == null) {
            instance = new OrderedDishDAO();
        }
        return instance;
    }

    private OrderedDishDAO() {
        super(OrderedDish.class);
    }
}
