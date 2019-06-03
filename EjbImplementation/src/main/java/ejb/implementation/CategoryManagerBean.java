package ejb.implementation;

import dao.CategoryDAO;
import ejb.dto.Category;
import ejb.interfaces.CategoryManager;

import java.util.List;
import java.util.Random;

public class CategoryManagerBean implements CategoryManager {

    public Category getCategory(Integer categoryId) {
        return CategoryDAO.getInstance().getItem(categoryId);
    }

    public Category getCategory(String categoryName) {
        List<Category> categories = CategoryDAO.getInstance().getItems();

        for (Category category : categories) {
            if (category.getName().equals(categoryName))
                return category;
        }

        return null;
    }

    public List<Category> getCategories() {
        return CategoryDAO.getInstance().getItems();
    }

    public void addCategory(String name) {
        Category category = new Category();
        Random generator = new Random();
        category.setId(generator.nextInt(999999)); //TODO - zrobic automatyczne generowanie ID dla kazdej klasy
        category.setName(name);
        CategoryDAO.getInstance().addItem(category);
    }
}
