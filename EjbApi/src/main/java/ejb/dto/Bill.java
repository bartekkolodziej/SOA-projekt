package ejb.dto;

import javax.persistence.*;

@Entity()
@Table(name = "Bills")
public class Bill extends AbstractDTO {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "value", nullable = false)
    private double value;

    @OneToOne
    private User customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
