package com.example.Portafolio.security.repository;

import com.example.Portafolio.security.entity.Rol;
import com.example.Portafolio.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
