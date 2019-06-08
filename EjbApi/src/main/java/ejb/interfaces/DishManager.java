package ejb.interfaces;

import ejb.dto.Dish;
import java.util.List;

public interface DishManager {
    List<Dish> getDishes();
    Dish getDish(Integer dishId);
    Dish getDish(String dishName);
    void addDish(Dish dish);
}
