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
    @Column(name = "Id", nullable = false)
    private int id;

    @OneToMany
    private List<Dish> dishes;

    @OneToOne
    private User customer;

    @Column(name = "OrderDate", nullable = false)
    private Date borrowDate;


    @Column(name = "OrderFinalisationDate", nullable = false)
    private Date returnDueDate;

    @Column(name = "ReturnedDate")
    private Date returnedDate;

    @Column(name = "Status")
    private String status;

    @Column(name = "Value")
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
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
}
