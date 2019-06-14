package dao;

import ejb.dto.Menu;

public class MenuDAO extends AbstractDAO<Menu> {
    private static MenuDAO instance;

    public static MenuDAO getInstance() {
        if (instance == null) {
            instance = new MenuDAO();
        }
        return instance;
    }

    private MenuDAO() {
        super(Menu.class);
    }
}
