package com.cuatroa.retouno.repository.crud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cuatroa.retouno.model.User;

// Hereda de una interfaz de Spring
public interface UserCrudRepository extends CrudRepository<User, Integer> {
   // Agregar métodos que hacen consultas (findBy)
   Optional<User> findByEmail(String email);

   Optional<User> findByEmailAndPassword(String email, String password);
}
