package ejb.dto;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


@Entity()
@Table(name = "Orders")
@Access(AccessType.FIELD)
public class Order extends AbstractDTO {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @OneToMany(mappedBy = "order", orphanRemoval=true)
    private List<OrderedDish> orderedDishes;

    @ManyToOne
    @JoinColumn(name="customer")
    private User customer;

    @Column(name = "orderDate", nullable = false)
    private Date borrowDate;

    @Column(name = "orderFinalisationDate", nullable = false)
    private Date returnDueDate;

    @Column(name = "returnedDate")
    private Date returnedDate;

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

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDueDate() {
        return returnDueDate;
    }

    public void setReturnDueDate(Date returnDueDate) {
        this.returnDueDate = returnDueDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
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
