package ejb.implementation;


import dao.MenuDAO;
import ejb.dto.Menu;
import ejb.interfaces.MenuManager;

import java.util.List;
import java.util.stream.Collectors;

public class MenuManagerBean implements MenuManager {

    private CategoryManagerBean categoryManagerBean = new CategoryManagerBean();

    public Menu getCurrentMenu() {
        List<Menu> menuList = MenuDAO
                .getInstance()
                .getItems()
                .stream()
                .filter(e -> e.getStatus().equals("current"))
                .collect(Collectors.toList());
        if(menuList.isEmpty()){
            for (Menu e : MenuDAO.getInstance().getItems()) {
                if (e.getMenuName().equals("empty menu"))
                    return e;
            }
            addMenu("empty menu");
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
                .filter(e -> e.getStatus().equals("archived"))
                .collect(Collectors.toList());
    }

    public Menu getMenu(Integer menuId) {
        return MenuDAO.getInstance().getItem(menuId);
    }

    public void deleteMenu(Menu menu) {
        menu.setStatus("deleted");
        menu.getCategories().forEach(e -> categoryManagerBean.deleteCategory(e.getId()));
        MenuDAO.getInstance().updateItem(menu);
    }

    public void archiveMenu(Menu menu) {
        menu.setStatus("archived");
        MenuDAO.getInstance().updateItem(menu);
    }

    public void unarchiveMenu(String menuName) {
        Menu currentMenu = getCurrentMenu();
        currentMenu.setStatus("archived");
        MenuDAO.getInstance().updateItem(currentMenu);
        for (Menu menu : MenuDAO.getInstance().getItems()) {
            if(menu.getMenuName().equals(menuName)) {
                menu.setStatus("current");
                MenuDAO.getInstance().updateItem(menu);
                break;
            }
        }
    }

    public void addMenu(String menuName) {
        MenuDAO.getInstance().getItems().forEach(e -> {
            if(e.getStatus().equals("current")){
                e.setStatus("archived");
                MenuDAO.getInstance().updateItem(e);
            }
        });

        Menu menu = new Menu();
        menu.setMenuName(menuName);
        menu.setStatus("current");
        MenuDAO.getInstance().addItem(menu);

    }
}
