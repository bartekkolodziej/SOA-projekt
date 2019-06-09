package controllers;

import dao.CategoryDAO;

import ejb.dto.Category;
import ejb.dto.Dish;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import java.util.List;

@javax.faces.bean.ViewScoped
@ManagedBean(name = "MenuController")
public class MenuController {

    public MenuController() {
        this.getCategoriesFromDB();
    }

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void getCategoriesFromDB(){
        this.categories = CategoryDAO.getInstance().getItems();
    }

}
