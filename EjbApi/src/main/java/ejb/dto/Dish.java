package ejb.dto;

import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import java.io.Serializable;

@Entity()
@Table(name = "Dishes")
@Access(AccessType.FIELD)
public class Dish extends AbstractDTO{

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Category.class)
    private Category category;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Price", nullable = false)
    private String price;

    @Column(name = "Weight", nullable = false)
    private String weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
