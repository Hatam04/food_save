package com.upc.food_save.repositories;

import com.upc.food_save.entities.RetoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RetoUsuarioRepository extends JpaRepository<RetoUsuario, Long> {
    List<RetoUsuario> findByUsuario_Id(Long idUsuario);
}
