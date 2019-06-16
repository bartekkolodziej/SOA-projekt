package ejb.interfaces;

import ejb.dto.Category;
import ejb.dto.Menu;

import java.util.List;

public interface CategoryManager {
    Category getCategory(Integer categoryId);
    Category getCategory(String categoryName);
    List<Category> getCategories();
    void addCategory(Category category, Menu menu);
    void deleteCategory(Integer categoryId);
    void archiveCategory(Category category);
}
