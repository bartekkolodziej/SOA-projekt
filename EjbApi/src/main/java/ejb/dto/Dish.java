package ejb.dto;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity()
@Table(name = "Dishes")
public class Dish extends AbstractDTO{

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JsonbTransient
    @JoinColumn(name="category_id")
    private Category category;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
