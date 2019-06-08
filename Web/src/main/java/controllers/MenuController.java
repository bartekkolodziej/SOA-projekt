package controllers;

import dao.CategoryDAO;

import ejb.dto.Category;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name = "MenuController")
public class MenuController {

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public MenuController() {
        this.getCategoriesFromDB();
    }

    public void getCategoriesFromDB() {
        this.categories = CategoryDAO.getInstance().getItems();
    }
}
