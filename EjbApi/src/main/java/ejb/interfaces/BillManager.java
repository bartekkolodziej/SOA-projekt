package ejb.interfaces;

import ejb.dto.Bill;
import ejb.dto.Order;
import ejb.dto.User;

import java.util.List;

public interface BillManager {
    Bill getBill(Integer billId);
    List<Bill> getBills();
    void updateBill(Bill bill);
    Bill addBill(User customer, Integer value, List<Order> orders);
}
