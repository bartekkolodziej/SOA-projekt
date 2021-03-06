package ejb.implementation;

import dao.DishDAO;
import dao.OrderDAO;
import dao.OrderedDishDAO;
import dao.SubscriptionDAO;
import ejb.dto.Dish;
import ejb.dto.OrderedDish;
import ejb.interfaces.DishManager;

import java.util.List;
import java.util.stream.Collectors;

public class DishManagerBean implements DishManager {


    public List<Dish> getDishes() {
        return DishDAO.getInstance().getItems();
    }

    public List<Dish> getAvailableDishes() {
        List<Dish> dishes = DishDAO.getInstance().getItems();
        return dishes.stream().filter(e -> e.getStatus().equals("available")).collect(Collectors.toList());
    }

    public List<Dish> getArchivedDishes() {
        List<Dish> dishes = DishDAO.getInstance().getItems();
        return dishes.stream().filter(e -> e.getStatus().equals("archived")).collect(Collectors.toList());
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

    public void deleteDish(Integer dishId) {
        Dish dish = DishDAO.getInstance().getItem(dishId);
        List<OrderedDish> orderedDishes = OrderedDishDAO.getInstance().getItems();
        boolean canBeDeleted = true;

       for(OrderedDish od: orderedDishes){
           if(od.getDish().getId() == dishId) {
               canBeDeleted = false;
               if(od.getOrder() != null && od.getOrder().getStatus().equals("delivered")) {
                   archiveDish(dish);
               } else if(od.getOrder() != null) {
                   od.getOrder().setStatus("deleted");
                   OrderDAO.getInstance().updateItem(od.getOrder());
                   archiveDish(dish);
               }
               if(od.getSubscription() != null && od.getSubscription().getStatus().equals("ongoing")){
                   od.getSubscription().setStatus("deleted");
                   SubscriptionDAO.getInstance().updateItem(od.getSubscription());
                   archiveDish(dish);
               }
           }
       }

       if(canBeDeleted)
         DishDAO.getInstance().deleteItem(dishId);
    }

    public void archiveDish(Dish dish) {
        dish.setStatus("archived");
        DishDAO.getInstance().updateItem(dish);
    }

    public void unarchiveDish(Dish dish) {
        dish.setStatus("available");
        DishDAO.getInstance().updateItem(dish);
    }

    public boolean addDish(Dish dish) {
        dish.setStatus("available");
        DishDAO.getInstance().addItem(dish);
        return false;
    }
}
