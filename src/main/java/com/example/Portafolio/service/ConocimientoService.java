package com.example.Portafolio.service;

import com.example.Portafolio.model.Conocimiento;
import com.example.Portafolio.repository.ConocimientoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ConocimientoService implements IConocimientoService {

    @Autowired
    public ConocimientoRepository conoRepo;

    @Override
    public List<Conocimiento> verConocimientos() {
        return conoRepo.findAll();
    }

    @Override
    public void crearConocimiento(Conocimiento cono) {
        conoRepo.save(cono);
    }

    @Override
    public void borrarConocimiento(Long id) {
        conoRepo.deleteById(id);
    }

    @Override
    public Conocimiento buscarConocimiento(Long id) {
        return conoRepo.findById(id).orElse(null);
    }

}
