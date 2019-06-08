package controllers;

import dao.CategoryDAO;
import ejb.dto.Category;
import ejb.implementation.CategoryManagerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "CategoryController")
public class CategoryController {

    private CategoryManagerBean categoryManagerBean = new CategoryManagerBean();

    private Category category = new Category();

    private String action;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void addCategory() {
        this.categoryManagerBean.addCategory(this.category);
    }

    public void removeCategory(Integer categoryId) {
        CategoryDAO.getInstance().deleteItem(categoryId);
    }

    public String redirectToCategoryPage(Category category) {
        if (category != null)
            setAction("edit");
        else
            setAction("add");
        return "categoryPage?faces-redirect=true";
    }
}
