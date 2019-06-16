package ejb.dto;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "Subscriptions")
public class Subscription extends AbstractDTO{
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "time")
    private String time;

    @OneToMany(mappedBy = "subscription", orphanRemoval = true)
    private List<OrderedDish> dishes;

    @Column(name = "price")
    private Integer price;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name="customer_id")
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

    public List<OrderedDish> getDishes() {
        return dishes;
    }

    public void setDishes(List<OrderedDish> dishes) {
        this.dishes = dishes;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
