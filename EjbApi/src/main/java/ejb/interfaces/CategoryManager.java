package ejb.interfaces;

import ejb.dto.Category;

import java.util.List;

public interface CategoryManager {
    Category getCategory(Integer categoryId);
    Category getCategory(String categoryName);
    List<Category> getCategories();
    void addCategory(String name);
}
