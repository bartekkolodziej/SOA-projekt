package ejb.implementation;

import dao.CategoryDAO;
import dao.OrderDAO;
import dao.OrderedDishDAO;
import ejb.dto.Category;
import ejb.dto.Menu;
import ejb.dto.OrderedDish;
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

    public void addCategory(Category category, Menu menu) {
        Random generator = new Random();
        category.setId(generator.nextInt(999999)); //TODO - zrobic automatyczne generowanie ID dla kazdej klasy
        category.setMenu(menu);
        category.setStatus("available");
        CategoryDAO.getInstance().addItem(category);
    }

    public void deleteCategory(Integer categoryId) {
        Category category = CategoryDAO.getInstance().getItem(categoryId);
        List<OrderedDish> orderedDishes = OrderedDishDAO.getInstance().getItems();
        boolean canBeDeleted = true;

        for(OrderedDish od: orderedDishes){
            if(od.getDish().getCategory().getId() == categoryId) {
                canBeDeleted = false;
                System.out.println("order status: " + od.getOrder().getStatus());
                if(od.getOrder().getStatus().equals("delivered")) {
                    archiveCategory(category);
                } else {
                    od.getOrder().setStatus("deleted");
                    OrderDAO.getInstance().updateItem(od.getOrder());
                    archiveCategory(category);
                }
            }
        }
        if(canBeDeleted)
            CategoryDAO.getInstance().deleteItem(categoryId);
    }

    public void archiveCategory(Category category) {
        category.setStatus("archived");
        CategoryDAO.getInstance().updateItem(category);
    }
}
