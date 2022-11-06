package com.cuatroa.retouno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuatroa.retouno.model.User;
import com.cuatroa.retouno.repository.UserRepository;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;

   // Listar todos
   public List<User> getAll() {
      return userRepository.getAll();
   }

   // Buscar uno
   public Optional<User> getUser(int id) {
      return userRepository.getUser(id);
   }

   // Guardar
   public User registrar(User user) {
      // Registro nuevo
      if (user.getId() == null) {
         if (existeEmail(user.getEmail()) == false) {
            // Email no exists
            return userRepository.save(user);
         } else {
            // Email existente
            return user;
         }
      } else {
         // Registro existente
         return user;
      }
   }

   // Validar si existe un email
   public boolean existeEmail(String email) {
      return userRepository.existeEmail(email);
   }

   // Autenticar usuario
   public User autenticarUsuario(String email, String password) {
      Optional<User> usuario = userRepository.autenticarUsuario(email, password);
      // No encontro registro
      if (!usuario.isPresent()) {
         return new User(email, password, "NO DEFINIDO");
      } else {
         // Si encontro registros
         return usuario.get();
      }
   }
}
