package com.cuatroa.retouno.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// Me permite que esta clase represente a una tabla de la BD
@Entity
// Nombre y condiciones para la tabla (indice=campo unico)(Va a tener una lista
// de columnas = user_email)(el indice es único, no se repite en la tabla)
@Table(name = "users", indexes = @Index(name = "indx_email", columnList = "user_email", unique = true))
// Genera los getters y setters en tiempo de ejecución
@Data
// Genera constructor con argumentos
@RequiredArgsConstructor
// Genera constructor sin argumentos
@NoArgsConstructor
// Por seguridad al transmitir datos en la red, se debe implementar la interfaz
// (Serializable)
public class User implements Serializable {
   // Llave primaria
   @Id
   // Defino la estrategia como voy a definir dicha llave
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   // Obligatoriedad
   @NonNull
   // Defino otras propiedades para la columna (obligatoria = nullable)
   @Column(name = "user_email", nullable = false, length = 50)
   private String email;
   @NonNull
   @Column(name = "user_password", nullable = false, length = 50)
   private String password;
   @NonNull
   @Column(name = "user_name", nullable = false, length = 80)
   private String name;
}
