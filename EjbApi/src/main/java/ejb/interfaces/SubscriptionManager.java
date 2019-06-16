package ejb.interfaces;

import ejb.dto.Order;
import ejb.dto.OrderedDish;
import ejb.dto.User;

import java.util.List;

public interface SubscriptionManager {
    void addSubscription(String frequency, String time, Integer price, List<OrderedDish> orderedDishes, User customer);
    void removeSubscription(Integer subId);
}
