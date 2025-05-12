package com.upc.food_save.repositories;

import com.upc.food_save.entities.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    List<Alimento> findByUsuario_Id(Long idUsuario);
}
