package com.upc.food_save.repositories;

import com.upc.food_save.entities.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByUsuario_IdOrderByFechaDesc(Long idUsuario);
}
