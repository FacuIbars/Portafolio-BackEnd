package com.example.Portafolio.service;

import com.example.Portafolio.model.Proyecto;
import java.util.List;

public interface IProyectoService {

    public List<Proyecto> verProyectos();

    public void crearProyecto(Proyecto proye);

    public void borrarProyecto(Long id);

    public Proyecto buscarProyecto(Long id);
}
