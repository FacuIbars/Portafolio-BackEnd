package com.example.Portafolio.repository;

import com.example.Portafolio.model.Conocimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ConocimientoRepository extends JpaRepository<Conocimiento, Long> {

}
