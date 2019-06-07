package controllers;

import dao.CategoryDAO;
import ejb.dto.Category;
import ejb.implementation.DishManagerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@ManagedBean(name = "DishController")
public class DishController implements Serializable {

    private DishManagerBean dishManagerBean = new DishManagerBean();

    private String name;

    private int price;

    private int weight;

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void addDish() {
        System.out.println("Category name: " + this.categoryName);
        this.dishManagerBean.addDish(this.name, this.weight, this.price, this.categoryName);
    }

    public List<Category> getCategories(){
        return CategoryDAO.getInstance().getItems();
    }
}
