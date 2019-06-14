package controllers;

import dao.CategoryDAO;

import dao.OrderDAO;
import dao.OrderedDishDAO;
import dao.UserDAO;
import ejb.dto.*;
import ejb.implementation.BillManagerBean;
import ejb.implementation.MenuManagerBean;
import ejb.implementation.OrderManagerBean;
import ejb.implementation.OrderedDishManagerBean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SessionScoped
@ManagedBean(name = "MenuController")
public class MenuController implements Serializable {

    private MenuManagerBean menuManagerBean = new MenuManagerBean();

    public MenuController() {
        this.updateMenu();
    }

    private Menu menu;

    private List<Menu> archivedMenus = menuManagerBean.getArchivedMenus();

    private Menu menuToChange;

    public Menu getMenuToChange() {
        return menuToChange;
    }

    public void setMenuToChange(Menu menuToChange) {
        this.menuToChange = menuToChange;
    }

    public String onArchiveMenuSelect() {
        System.out.println("menu to change:  " + menuToChange);
        menuManagerBean.unarchiveMenu(menuToChange);
        return "index?faces-redirect=true";
    }

    public void updateMenu(){
        this.menu = menuManagerBean.getCurrentMenu();
    }

    public List<Menu> getArchivedMenus() {
        return archivedMenus;
    }

    public void setArchivedMenus(List<Menu> archivedMenus) {
        this.archivedMenus = archivedMenus;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void addMenu(){
        menuManagerBean.addMenu(menu);
    }

    public String redirectToMenuPage(){
        return "menuPage?faces-redirect=true";
    }


}
