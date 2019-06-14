package ejb.interfaces;

import ejb.dto.Dish;
import java.util.List;

public interface DishManager {
    List<Dish> getAvailableDishes();
    List<Dish> getArchivedDishes();
    Dish getDish(Integer dishId);
    Dish getDish(String dishName);
    void deleteDish(Integer dishId);
    void archiveDish(Dish dish);
    void unarchiveDish(Dish dish);
    boolean addDish(Dish dish);
}
