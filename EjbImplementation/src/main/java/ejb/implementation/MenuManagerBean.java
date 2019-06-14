package ejb.implementation;


import dao.CategoryDAO;
import dao.MenuDAO;
import ejb.dto.Category;
import ejb.dto.Menu;
import ejb.interfaces.MenuManager;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MenuManagerBean implements MenuManager {
    public Menu getCurrentMenu() {
        List<Menu> menuList = MenuDAO
                .getInstance()
                .getItems()
                .stream()
                .filter(e -> e.getStatus().equals("current"))
                .collect(Collectors.toList());
        if(menuList.isEmpty()){
            Menu menu = new Menu();
            menu.setMenuName("exampleMenu");
            menu.setStatus("current");
            addMenu(menu);
            return getCurrentMenu();
        }
        else
            return menuList.get(0);
    }

    public List<Menu> getArchivedMenus() {
        return MenuDAO
                .getInstance()
                .getItems()
                .stream()
                .filter(e -> e.getStatus().equals("archive"))
                .collect(Collectors.toList());
    }

    public Menu getMenu(Integer menuId) {
        return MenuDAO.getInstance().getItem(menuId);
    }

    public void deleteMenu(Integer menuId) {
        MenuDAO.getInstance().deleteItem(menuId);
    }

    public void archiveMenu(Menu menu) {
        menu.setStatus("archive");
        MenuDAO.getInstance().updateItem(menu);
    }

    public void unarchiveMenu(Menu menu) {
        Menu currentMenu = getCurrentMenu();
        currentMenu.setStatus("archive");
        MenuDAO.getInstance().updateItem(currentMenu);
        menu.setStatus("current");
        MenuDAO.getInstance().updateItem(menu);
    }

    public void addMenu(Menu menu) {
        MenuDAO.getInstance().getItems().forEach(e -> {
            if(e.getStatus().equals("current")){
                e.setStatus("archive");
                MenuDAO.getInstance().updateItem(e);
            }
        });

        Random generator = new Random();
        menu.setId(generator.nextInt(999999)); //TODO - zrobic automatyczne generowanie ID dla kazdej klasy
        MenuDAO.getInstance().addItem(menu);

    }
}
