package dao;

import ejb.dto.Subscription;

public class SubscriptionDAO extends AbstractDAO<Subscription> {
    private static SubscriptionDAO instance;

    public static SubscriptionDAO getInstance() {
        if (instance == null) {
            instance = new SubscriptionDAO();
        }
        return instance;
    }

    private SubscriptionDAO() {
        super(Subscription.class);
    }
}


