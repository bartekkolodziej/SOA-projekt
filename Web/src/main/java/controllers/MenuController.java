package controllers;

import ejb.dto.*;
import ejb.implementation.MenuManagerBean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@ManagedBean(name = "MenuController")
public class MenuController implements Serializable {

    private MenuManagerBean menuManagerBean = new MenuManagerBean();

    public MenuController() {
    }

    private String menuName;

    private List<Menu> archivedMenus = menuManagerBean.getArchivedMenus();

    private String menuToChange;

    public String getMenuToChange() {
        return menuToChange;
    }

    public void setMenuToChange(String menuToChange) {
        this.menuToChange = menuToChange;
    }

    public String onArchiveMenuSelect() {
        menuManagerBean.unarchiveMenu(menuToChange);
        updateArchivedMenus();
        return "index?faces-redirect=true";
    }

    public List<Menu> getArchivedMenus() {
        return archivedMenus;
    }

    public void setArchivedMenus(List<Menu> archivedMenus) {
        this.archivedMenus = archivedMenus;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String addMenu(){
        menuManagerBean.addMenu(menuName);
        updateArchivedMenus();
        return "index?faces-redirect=true";
    }

    public String redirectToMenuPage(){
        return "menuPage?faces-redirect=true";
    }


    public String removeMenu(Menu menu){
        menuManagerBean.deleteMenu(menu);
        updateArchivedMenus();
        return "index?faces-redirect=true";
    }

    public String archiveMenu(Menu menu){
        menuManagerBean.archiveMenu(menu);
        updateArchivedMenus();
        return "index?faces-redirect=true";
    }

    private void updateArchivedMenus() {
        this.archivedMenus = menuManagerBean.getArchivedMenus();
    }
}
