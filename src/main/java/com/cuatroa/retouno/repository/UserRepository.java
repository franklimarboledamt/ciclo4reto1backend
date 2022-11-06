package com.cuatroa.retouno.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cuatroa.retouno.repository.crud.UserCrudRepository;

import java.util.List;
import java.util.Optional;

import com.cuatroa.retouno.model.User;

@Repository
public class UserRepository {
   @Autowired
   private UserCrudRepository userCrudRepository;

   // Listar todos los usuarios
   public List<User> getAll() {
      return (List<User>) userCrudRepository.findAll();
   }

   // Ver un usuario
   public Optional<User> getUser(int id) {
      return userCrudRepository.findById(id);
   }

   // Guardar o actualizar un usuario
   public User save(User user) {
      return userCrudRepository.save(user);
   }

   // Verificar si existe un email
   public boolean existeEmail(String email) {
      Optional<User> usuario = userCrudRepository.findByEmail(email);
      return usuario.isPresent();
   }

   // Autenticar usuario
   public Optional<User> autenticarUsuario(String email, String password) {
      return userCrudRepository.findByEmailAndPassword(email, password);
   }
}
