package cl.miguelramos.pizzeria.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemId implements Serializable {

  private Integer idOrder;
  private Integer idItem;

  // Nótese que esta clase no tiene nada de jpa es una clase normal

  // la interface Serializable es necesaria porque vamos a incluir(Incrustar dentro de otro entity) es necesario

  // equa

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderItemId that = (OrderItemId) o;
    return Objects.equals(idOrder, that.idOrder) && Objects.equals(idItem, that.idItem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idOrder, idItem);
  }
}
