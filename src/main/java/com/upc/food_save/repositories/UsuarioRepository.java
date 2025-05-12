package com.upc.food_save.repositories;

import com.upc.food_save.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoAndContrasenia(String correo, String contrasenia);
    boolean existsByCorreo(String correo);
}
