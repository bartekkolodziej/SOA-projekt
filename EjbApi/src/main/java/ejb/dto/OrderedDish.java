package ejb.dto;

import javax.persistence.*;


@Entity()
@Table(name = "OrderedDishes")
public class OrderedDish extends AbstractDTO {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name="dish")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "order")
    private Order order;
}
