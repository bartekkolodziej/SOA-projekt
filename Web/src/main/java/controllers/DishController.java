package controllers;

import dao.CategoryDAO;
import dao.DishDAO;
import ejb.dto.Category;
import ejb.dto.Dish;
import ejb.implementation.CategoryManagerBean;
import ejb.implementation.DishManagerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@ManagedBean(name = "DishController")
public class DishController implements Serializable {

    private DishManagerBean dishManagerBean = new DishManagerBean();

    private CategoryManagerBean categoryManagerBean = new CategoryManagerBean();

    private Dish dish = new Dish();

    private String action;

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addDish() {
        System.out.println("KKKKKKKKKKEfdsdses");
        dish.setCategory(categoryManagerBean.getCategory(this.categoryName));
        this.dishManagerBean.addDish(dish);
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Category> getCategories(){
        return CategoryDAO.getInstance().getItems();
    }

    public void removeDish(Integer dishId) {
        DishDAO.getInstance().deleteItem(dishId);
    }

    public String redirectToDishPage(Dish dish){
        if(dish != null)
            setAction("edit");
        else
            setAction("add");
        return "dishPage?faces-redirect=true";
    }
}
