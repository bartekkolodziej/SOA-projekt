package ejb.interfaces;

import ejb.dto.Bill;
import ejb.dto.User;

public interface BillManager {
    Bill getBill(Integer billId);
    void addBill(Integer value, User customer);
}
