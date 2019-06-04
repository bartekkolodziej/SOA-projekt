package ejb.implementation;

import dao.OrderedDishDAO;
import ejb.dto.Dish;
import ejb.dto.Order;
import ejb.dto.OrderedDish;
import ejb.interfaces.OrderedDishManager;

import java.util.List;

public class OrderedDishManagerBean implements OrderedDishManager {
    @Override
    public List<OrderedDish> getOrderedDishes() {
        return OrderedDishDAO.getInstance().getItems();
    }

    @Override
    public void addOrderedDish(Dish dish, Order order) {
        OrderedDish orderedDish = new OrderedDish();
        orderedDish.setDish(dish);
        orderedDish.setOrder(order);
        OrderedDishDAO.getInstance().addItem(orderedDish);
    }
}
