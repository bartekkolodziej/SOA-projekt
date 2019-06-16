package ejb.dto;

import javax.persistence.*;
import java.util.List;


@Entity()
@Table(name = "Categories")
public class Category extends AbstractDTO {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private List<Dish> dishes;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
