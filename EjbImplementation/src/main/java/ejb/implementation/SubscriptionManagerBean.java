package ejb.implementation;

import ejb.dto.Order;
import ejb.dto.Subscription;
import ejb.dto.User;
import ejb.interfaces.SubsrciptionManager;

public class SubscriptionManagerBean implements SubsrciptionManager {
    @Override
    public void addSubscription(String frequency, Order order, User customer) {
        Subscription subscription = new Subscription();
        subscription.setCustomer(customer);
        subscription.setFrequency(frequency);
        subscription.setOrder(order);
    }
}
