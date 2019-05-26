package ejb.dto;

import javax.persistence.*;


@Entity()
@Table(name = "Categories")
@Access(AccessType.FIELD)
public class Category extends AbstractDTO {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

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
