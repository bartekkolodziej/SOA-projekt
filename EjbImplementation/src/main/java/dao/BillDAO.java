package dao;

import ejb.dto.Bill;

public class BillDAO extends AbstractDAO<Bill> {
    private static BillDAO instance;

    public static BillDAO getInstance() {
        if (instance == null) {
            instance = new BillDAO();
        }
        return instance;
    }

    private BillDAO() {
        super(Bill.class);
    }
}
