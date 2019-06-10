package ejb.implementation;

import dao.BillDAO;
import ejb.dto.Bill;
import ejb.dto.Order;
import ejb.dto.User;
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

    public void updateBill(Bill bill) {
        BillDAO.getInstance().updateItem(bill);
    }

    public Bill addBill(User customer, Integer value, List<Order> orders) {
        Bill bill = new Bill();
        Random generator = new Random();
        bill.setId(generator.nextInt(999999)); //TODO - zrobic automatyczne generowanie ID dla kazdej klasy
        bill.setCustomer(customer);
        System.out.println("orderki:   " + orders);
        bill.setFinalValue(value);
        bill.setOrders(orders);
        BillDAO.getInstance().addItem(bill);
        return bill;
    }
}
