package ejb.implementation;

import dao.DishDAO;
import ejb.dto.Dish;
import ejb.interfaces.DishManager;

import java.util.List;
import java.util.Random;

public class DishManagerBean implements DishManager {


    public List<Dish> getDishes() {
        return DishDAO.getInstance().getItems();
    }

    public Dish getDish(Integer dishId) {
        return DishDAO.getInstance().getItem(dishId);
    }

    public Dish getDish(String dishName) {
        List<Dish> dishes = DishDAO.getInstance().getItems();

        for (Dish dish : dishes) {
            if (dish.getName().equals(dishName))
                return dish;
        }
        return null;
    }

    public boolean addDish(Dish dish) {
        Random generator = new Random();
        dish.setId(generator.nextInt(999999)); //TODO - zrobic automatyczne generowanie ID dla kazdej klasy
        System.out.println("Dsih category:  " + dish.getCategory());
        DishDAO.getInstance().addItem(dish);
        return false;
    }
}
