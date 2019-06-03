package ejb.implementation;

import dao.BillDAO;
import ejb.dto.Bill;
import ejb.interfaces.BillManager;

import java.util.List;
import java.util.Random;

public class BillManagerBean implements BillManager {

    private UserManagerBean userManagerBean = new UserManagerBean();

    public Bill getBill(Integer billId) {
        return BillDAO.getInstance().getItem(billId);
    }

    public List<Bill> getBills() {
        return BillDAO.getInstance().getItems();
    }

    public void addBill(Integer value, String customerName) {
        Bill bill = new Bill();
        Random generator = new Random();
        bill.setId(generator.nextInt(999999)); //TODO - zrobic automatyczne generowanie ID dla kazdej klasy
        bill.setFinalValue(value);
        bill.setCustomer(this.userManagerBean.getUser(customerName));
        BillDAO.getInstance().addItem(bill);
    }
}
