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

    @OneToOne
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
}
