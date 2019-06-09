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
    private List<Dish> orderedDishes;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name="bill_id")
    private Bill bill;

    @Column(name = "orderDate", nullable = false)
    private Date orderDate;

    @Column(name = "orderFinalisationDate", nullable = false)
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer value) {
        this.price = value;
    }

    public List<Dish> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(List<Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }
}
