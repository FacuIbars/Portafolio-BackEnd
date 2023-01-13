package com.example.Portafolio.service;

import com.example.Portafolio.model.HabilidadBlanda;
import com.example.Portafolio.repository.HabilidadBlandaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class HabilidadBlandaService implements IHabilidadBlandaService {

    @Autowired
    public HabilidadBlandaRepository habiRepo;

    @Override
    public List<HabilidadBlanda> verHabilidadBlanda() {
        return habiRepo.findAll();
    }

    @Override
    public void crearHabilidadBlanda(HabilidadBlanda habi) {
        habiRepo.save(habi);
    }

    @Override
    public void borrarHabilidadBlanda(Long id) {
        habiRepo.deleteById(id);
    }

    @Override
    public HabilidadBlanda buscarHabilidadBlanda(Long id) {
        return habiRepo.findById(id).orElse(null);
    }

}
