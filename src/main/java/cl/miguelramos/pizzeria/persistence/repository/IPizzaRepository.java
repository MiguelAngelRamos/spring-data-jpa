package cl.miguelramos.pizzeria.persistence.repository;

import cl.miguelramos.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface IPizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
}
