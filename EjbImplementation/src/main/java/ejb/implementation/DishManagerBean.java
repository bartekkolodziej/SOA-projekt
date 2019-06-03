package ejb.implementation;

import dao.DishDAO;
import ejb.dto.Dish;
import ejb.interfaces.DishManager;

import java.util.List;
import java.util.Random;

public class DishManagerBean implements DishManager {

    private CategoryManagerBean categoryManagerBean = new CategoryManagerBean();

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

    public void addDish(String name, Integer weight, Integer price, String categoryName) {
        Dish dish = new Dish();
        Random generator = new Random();
        dish.setId(generator.nextInt(999999)); //TODO - zrobic automatyczne generowanie ID dla kazdej klasy
        dish.setName(name);
        dish.setWeight(weight);
        dish.setPrice(price);
        dish.setCategory(this.categoryManagerBean.getCategory(categoryName)); //TODO - zrobic dodawanie kategorii

        DishDAO.getInstance().addItem(dish);
    }
}
