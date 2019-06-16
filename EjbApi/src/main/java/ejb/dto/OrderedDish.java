package ejb.dto;

import javax.persistence.*;


@Entity()
@Table(name = "OrderedDishes")
public class OrderedDish extends AbstractDTO {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @OneToOne
    private Dish dish;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Subscription subscription;

    public int getId() {
        return id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}