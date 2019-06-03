package dao;

import ejb.dto.Category;

public class CategoryDAO extends AbstractDAO<Category> {
    private static CategoryDAO instance;

    public static CategoryDAO getInstance() {
        if (instance == null) {
            instance = new CategoryDAO();
        }
        return instance;
    }

    private CategoryDAO() {
        super(Category.class);
    }
}
