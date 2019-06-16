package ejb.implementation;

import dao.SubscriptionDAO;
import ejb.dto.Order;
import ejb.dto.OrderedDish;
import ejb.dto.Subscription;
import ejb.dto.User;
import ejb.interfaces.SubscriptionManager;

import java.util.List;
import java.util.Random;

public class SubscriptionManagerBean implements SubscriptionManager {
    public void addSubscription(String frequency, String time, Integer price, List<OrderedDish> orderedDishes, User customer) {
        Random generator = new Random();
        Subscription subscription = new Subscription();
        subscription.setId(generator.nextInt(999999));
        subscription.setCustomer(customer);
        subscription.setDishes(orderedDishes);
        subscription.setPrice(price);
        subscription.setFrequency(frequency);
        subscription.setTime(time);
        SubscriptionDAO.getInstance().addItem(subscription);
    }

    public void removeSubscription(Integer subId) {

    }
}
