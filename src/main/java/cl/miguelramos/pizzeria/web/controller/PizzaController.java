package cl.miguelramos.pizzeria.web.controller;

import cl.miguelramos.pizzeria.persistence.entity.PizzaEntity;
import cl.miguelramos.pizzeria.service.PizzaService;
import cl.miguelramos.pizzeria.service.PizzaServiceJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

  // private final PizzaServiceJdbc pizzaService;
  private final PizzaService pizzaService;
  @Autowired
  public PizzaController(PizzaService pizzaService) {
    this.pizzaService = pizzaService;
  }

  @GetMapping
  public ResponseEntity<List<PizzaEntity>> getAll() {
    return ResponseEntity.ok(this.pizzaService.getAll());
  }

  @GetMapping("/{idPizza}")
  public ResponseEntity<PizzaEntity> get(@PathVariable  int idPizza) {
    return ResponseEntity.ok(this.pizzaService.get(idPizza));
  }

  @PostMapping
  public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizza) {
    if(pizza.getIdPizza() == null || !this.pizzaService.exists(pizza.getIdPizza())) {
      // se procesa esta solicitud
      return ResponseEntity.ok(this.pizzaService.save(pizza));
    }

    // si la pizza existe retornamos un error
    return ResponseEntity.badRequest().build();
  }

  @PutMapping
  public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza) {
    if(pizza.getIdPizza() != null && this.pizzaService.exists(pizza.getIdPizza())) {
      // se procesa esta solicitud
      // Siempre llamamos al método save los spring repository determinaran si trata de un save o updated
      return ResponseEntity.ok(this.pizzaService.save(pizza));
    }
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/{idPizza}")
  public ResponseEntity<Void> delete(@PathVariable int idPizza) {
    // verificar antes de borrar que la pizza si exista
    if(this.pizzaService.exists(idPizza)) {
      // si existe la eliminamos
      this.pizzaService.delete(idPizza);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.badRequest().build();
  }



}
