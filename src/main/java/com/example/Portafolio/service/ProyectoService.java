package com.example.Portafolio.service;

import com.example.Portafolio.model.Proyecto;
import com.example.Portafolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProyectoService implements IProyectoService {

    @Autowired
    public ProyectoRepository proRepo;

    @Override
    public List<Proyecto> verProyectos() {
        return proRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyecto proye) {
        proRepo.save(proye);
    }

    @Override
    public void borrarProyecto(Long id) {
        proRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proRepo.findById(id).orElse(null);
    }

}
