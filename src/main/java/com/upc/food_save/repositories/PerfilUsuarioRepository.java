package com.upc.food_save.repositories;

import com.upc.food_save.entities.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Long> {
    Optional<PerfilUsuario> findByUsuario_Id(Long idUsuario);
}
