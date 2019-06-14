package ejb.interfaces;

import ejb.dto.Category;
import ejb.dto.Menu;

import java.util.List;

public interface MenuManager {
    Menu getCurrentMenu();
    List<Menu> getArchivedMenus();
    Menu getMenu(Integer menuId);
    void deleteMenu(Integer menuId);
    void archiveMenu(Menu menu);
    void unarchiveMenu(Menu menu);
    void addMenu(Menu menu);

}
