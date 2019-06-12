package ejb.implementation;

import dao.OrderedDishDAO;
import ejb.dto.Dish;
import ejb.dto.Order;
import ejb.dto.OrderedDish;
import ejb.interfaces.OrderedDishManager;

import java.util.List;
import java.util.Random;

public class OrderedDishManagerBean implements OrderedDishManager {
    @Override
    public List<OrderedDish> getOrderedDishes() {
        return OrderedDishDAO.getInstance().getItems();
    }

    @Override
    public OrderedDish addOrderedDish(Dish dish, Order order) {
        OrderedDish orderedDish = new OrderedDish();
        Random generator = new Random();
        orderedDish.setId(generator.nextInt(999999)); //TODO - zrobic automatyczne generowanie ID dla kazdej klasy
        orderedDish.setDish(dish);
        orderedDish.setOrder(order);
        OrderedDishDAO.getInstance().addItem(orderedDish);
        return orderedDish;
    }
}