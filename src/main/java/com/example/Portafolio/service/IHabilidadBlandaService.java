package com.example.Portafolio.service;

import com.example.Portafolio.model.HabilidadBlanda;
import java.util.List;

public interface IHabilidadBlandaService {

    public List<HabilidadBlanda> verHabilidadBlanda();

    public void crearHabilidadBlanda(HabilidadBlanda Hab);

    public void borrarHabilidadBlanda(Long id);

    public HabilidadBlanda buscarHabilidadBlanda(Long id);
}
