package com.example.Portafolio.repository;

import com.example.Portafolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

}
