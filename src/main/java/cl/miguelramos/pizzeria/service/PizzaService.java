package cl.miguelramos.pizzeria.service;

import cl.miguelramos.pizzeria.persistence.entity.PizzaEntity;
import cl.miguelramos.pizzeria.persistence.repository.IPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
  private final IPizzaRepository pizzaRepository;

  @Autowired
  public PizzaService(IPizzaRepository pizzaRepository) {
    this.pizzaRepository = pizzaRepository;
  }

  public List<PizzaEntity> getAll() {
    return this.pizzaRepository.findAll();
  }

  public PizzaEntity get(int idPizza) {
    return this.pizzaRepository.findById(idPizza).orElse(null); // si no encuentra nada retorna null
  }

  public PizzaEntity save(PizzaEntity pizza) {
    return this.pizzaRepository.save(pizza);
  }

  public void delete(int idPizza) {
    this.pizzaRepository.deleteById(idPizza);
  }

  public boolean exists(int idPizza) {
    return this.pizzaRepository.existsById(idPizza); // retorna true si la pizza existe.
  }
}
