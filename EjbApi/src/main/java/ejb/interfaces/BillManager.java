package ejb.interfaces;

import ejb.dto.Bill;
import java.util.List;

public interface BillManager {
    Bill getBill(Integer billId);
    List<Bill> getBills();
    void addBill(Integer value, String customerName);
}
