package dao;

import ejb.dto.User;

public class UserDAO extends AbstractDAO<User> {
    private static UserDAO instance;

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    private UserDAO() {
        super(User.class);
    }
}
