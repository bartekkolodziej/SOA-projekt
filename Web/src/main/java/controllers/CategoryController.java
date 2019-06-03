package controllers;

import ejb.implementation.CategoryManagerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "CategoryController")
public class CategoryController {

    private CategoryManagerBean categoryManagerBean = new CategoryManagerBean();

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCategory() {
        this.categoryManagerBean.addCategory(this.name);
    }
}
