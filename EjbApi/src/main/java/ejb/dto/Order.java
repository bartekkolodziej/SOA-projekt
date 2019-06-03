package ejb.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity()
@Table(name = "Orders")
public class Order extends AbstractDTO {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @OneToMany(mappedBy = "order")
    private List<OrderedDish> orderedDishes;

    @ManyToOne
    @JoinColumn(name="customer")
    private User customer;

    @Column(name = "orderDate", nullable = false)
    private Date orderDate;

    @Column(name = "orderFinalisationDate", nullable = false)
    private Date finalisationDate;

    @Column(name = "status")
    private String status;

    @Column(name = "value")
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Date getorderDate() {
        return orderDate;
    }

    public void setorderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getfinalisationDate() {
        return finalisationDate;
    }

    public void setfinalisationDate(Date finalisationDate) {
        this.finalisationDate = finalisationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<OrderedDish> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(List<OrderedDish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }
}
