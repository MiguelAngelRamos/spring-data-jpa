package cl.miguelramos.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="order_item")
@IdClass(OrderItemId.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {

  @Id
  @Column(name="id_order", nullable = false)
  private Integer idOrder;

  @Id
  @Column(name="id_item", nullable = false)
  private Integer idItem;

  // tenemos 2 veces el @Id en 2 atributos, es porque este entity tiene una clave primaria compuesta
  // necesitamos el @IdClass para establecer esto.

  @Column(name="id_pizza", nullable = false)
  private Integer idPizza;

  @Column(nullable = false, columnDefinition = "Decimal(2,1)")
  private Double quantity;

  @Column(nullable = false, columnDefinition = "Decimal(5,2)")
  private Double price;

  // OrderItem con PizzaOrder (OrderEntity)
  // una orden puede tener muchos items
  @ManyToOne // se hace de esta forma esta es la tabla hija por la cual puede haber muchos registros por medio de una sola order
  @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
  private OrderEntity order;

  @OneToOne // Un ORDEN_ITEM solo puede tener una pizza
  @JoinColumn(name="id_pizza", referencedColumnName = "id_pizza",insertable = false, updatable = false )// columna donde ocurre el join
  private PizzaEntity pizza;


  /* insertable = false, updatable = false: Estas propiedades indican que la columna id_pizza en la tabla order_item no debe ser modificada o insertada directamente. Esto es porque la relación se maneja a través de la entidad y no directamente a través de operaciones en la columna.*/
}
