package ejb.dto;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "Menus")
public class Menu extends AbstractDTO {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "menuName", nullable = false)
    private String menuName;

    @OneToMany(mappedBy = "menu")
    private List<Category> categories;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}