package com.upc.food_save.security.repositories;
import com.upc.food_save.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
