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

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private List<OrderedDish> orderedDishes;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private User customer;

    @Column(name = "orderDate")
    private Date orderDate;

    @Column(name = "orderFinalisationDate")
    private Date finalisationDate;

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private Integer price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getFinalisationDate() {
        return finalisationDate;
    }

    public void setFinalisationDate(Date finalisationDate) {
        this.finalisationDate = finalisationDate;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer value) {
        this.price = value;
    }

    public List<OrderedDish> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(List<OrderedDish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

}
