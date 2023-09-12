package cl.miguelramos.pizzeria.service;

import cl.miguelramos.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceJdbc {
  private final JdbcTemplate jdbcTemplate;
  /* jdbcTemplate nos permite crear consultas sql
  desde java y convertir el resultado en clases java*/
  @Autowired
  public PizzaServiceJdbc(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<PizzaEntity> getAll() {
    // SI QUEREMOS OBTENER LAS PIZZAS NO DISPONIBLES
    return this.jdbcTemplate.query("SELECT * FROM pizza WHERE available = 0", new BeanPropertyRowMapper<>(PizzaEntity.class));
    // return this.jdbcTemplate.query("SELECT * FROM pizza", new BeanPropertyRowMapper<>(PizzaEntity.class));
  }


}
