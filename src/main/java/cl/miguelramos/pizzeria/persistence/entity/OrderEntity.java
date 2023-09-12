package cl.miguelramos.pizzeria.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="pizza_order")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id_order", nullable = false)
  private Integer idOrder;

  @Column(name="id_customer", nullable = false, length = 15)
  private String idCustomer;

  @Column(nullable = false, columnDefinition = "DATETIME")
  private LocalDateTime date;

  @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
  private Double total;

  @Column(nullable = false, columnDefinition = "CHAR(1)")
  private String method;
  @Column(name="additional_notes", length = 200)
  private String additionalNotes;

  // Esta relacionada con un cliente
  // una order esta relacionada con un cliente(customer)
  @OneToOne
  @JoinColumn(name="id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
  private CustomerEntity customer;

  // varios items lo que pueden estar en una misma order
  @OneToMany(mappedBy = "order") // un Order puede tener muchos items (observe que es el inverso de lo que existe en la clase hija)
  // nombre del atributo "order" que tenemos en la otra entidad con la relación contraria
  private List<OrderItemEntity> items;


}
  /* La clase LocalDateTime representa una fecha y hora sin información de zona horaria. Es decir, representa una fecha y hora en el sentido tradicional, como "2023-09-11T14:30:00", sin tener en cuenta si es UTC, GMT-5, etc.*/