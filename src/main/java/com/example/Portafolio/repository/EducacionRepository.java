package com.example.Portafolio.repository;

import com.example.Portafolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EducacionRepository extends JpaRepository<Educacion, Long> {

}
