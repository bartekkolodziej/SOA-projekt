package ejb.interfaces;

import ejb.dto.Order;
import ejb.dto.User;

public interface SubsrciptionManager {
    void addSubscription(String frequency, Order order, User customer );
}
