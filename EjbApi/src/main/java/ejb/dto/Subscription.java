package ejb.dto;

import javax.persistence.*;

@Entity()
@Table(name = "Subscriptions")
@Access(AccessType.FIELD)
public class Subscription extends AbstractDTO{
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "frequency")
    private String frequency;

    @OneToOne
    private Order order;

    @ManyToOne
    @JoinColumn(name="customer")
    private User customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
