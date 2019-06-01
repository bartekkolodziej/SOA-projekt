package ejb.dto;

import javax.persistence.*;
import java.util.List;


@Entity()
@Table(name = "Categories")
@Access(AccessType.FIELD)
public class Category extends AbstractDTO {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", orphanRemoval=true)
    private List<Dish> dishes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
