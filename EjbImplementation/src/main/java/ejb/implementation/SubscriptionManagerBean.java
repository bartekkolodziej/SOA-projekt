package ejb.implementation;

import dao.SubscriptionDAO;
import ejb.dto.OrderedDish;
import ejb.dto.Subscription;
import ejb.dto.User;
import ejb.interfaces.SubscriptionManager;

import java.util.List;

public class SubscriptionManagerBean implements SubscriptionManager {
    public Subscription addSubscription(String frequency, String time, Integer price, List<OrderedDish> orderedDishes, User customer) {
        Subscription subscription = new Subscription();
        subscription.setCustomer(customer);
        subscription.setDishes(orderedDishes);
        subscription.setPrice(price);
        subscription.setFrequency(frequency);
        subscription.setTime(time);
        subscription.setStatus("ongoing");
        SubscriptionDAO.getInstance().addItem(subscription);
        return subscription;
    }

    public void removeSubscription(Integer subId) {
       SubscriptionDAO.getInstance().deleteItem(subId);
    }

}
