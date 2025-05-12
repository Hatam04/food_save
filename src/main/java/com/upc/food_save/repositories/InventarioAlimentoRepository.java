package com.upc.food_save.repositories;

import com.upc.food_save.entities.InventarioAlimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventarioAlimentoRepository extends JpaRepository<InventarioAlimento, Long> {
    List<InventarioAlimento> findByUsuario_Id(Long idUsuario);
}
