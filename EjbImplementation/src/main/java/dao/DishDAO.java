package dao;

import ejb.dto.Dish;

public class DishDAO extends AbstractDAO<Dish>{
    private static DishDAO instance;

    public static DishDAO getInstance() {
        if (instance == null) {
            instance = new DishDAO();
        }
        return instance;
    }

    private DishDAO() {
        super(Dish.class);
    }
}
