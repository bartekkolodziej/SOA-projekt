package ejb.dto;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "Bills")
public class Bill extends AbstractDTO {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "finalValue", nullable = false) //TODO - to powinien byc typ double, ale postgres sypie errorami gdy sie tak dzieje
    private int finalValue;

    @OneToOne
    private User customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(int finalValue) {
        this.finalValue = finalValue;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
