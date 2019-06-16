package ejb.interfaces;

import ejb.dto.Category;
import ejb.dto.Menu;

import java.util.List;

public interface MenuManager {
    Menu getCurrentMenu();
    List<Menu> getArchivedMenus();
    Menu getMenu(Integer menuId);
    void deleteMenu(Menu menu);
    void archiveMenu(Menu menu);
    void unarchiveMenu(String menuName);
    void addMenu(String menuName);

}
