package ejb.implementation;

import dao.BillDAO;
import ejb.dto.Bill;
import ejb.dto.User;
import ejb.interfaces.BillManager;

import java.util.Random;

public class BillManagerBean implements BillManager {

    public Bill getBill(Integer billId) {
        return null;
    }

    public void addBill(Integer value, User customer) {
        Bill bill = new Bill();
        Random generator = new Random();
        bill.setId(generator.nextInt(999999)); //TODO - zrobic automatyczne generowanie ID dla kazdej klasy
        bill.setFinalValue(value);
        bill.setCustomer(customer);
        BillDAO.getInstance().addItem(bill);
    }
}
