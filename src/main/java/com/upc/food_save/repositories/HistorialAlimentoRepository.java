package com.upc.food_save.repositories;

import com.upc.food_save.entities.HistorialAlimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialAlimentoRepository extends JpaRepository<HistorialAlimento, Long> {
    List<HistorialAlimento> findByUsuario_IdOrderByFechaDesc(Long idUsuario);
}
