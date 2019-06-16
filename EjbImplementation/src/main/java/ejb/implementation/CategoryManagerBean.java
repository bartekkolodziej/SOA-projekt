package ejb.implementation;

import dao.CategoryDAO;
import dao.OrderDAO;
import dao.OrderedDishDAO;
import dao.SubscriptionDAO;
import ejb.dto.Category;
import ejb.dto.Menu;
import ejb.dto.OrderedDish;
import ejb.interfaces.CategoryManager;

import java.util.List;

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
                if(od.getOrder() != null && od.getOrder().getStatus().equals("delivered")) {
                    archiveCategory(category);
                } else if(od.getOrder() != null) {
                    od.getOrder().setStatus("deleted");
                    OrderDAO.getInstance().updateItem(od.getOrder());
                    archiveCategory(category);
                }
                if(od.getSubscription() != null && od.getSubscription().getStatus().equals("ongoing")){
                    od.getSubscription().setStatus("deleted");
                    SubscriptionDAO.getInstance().updateItem(od.getSubscription());
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
