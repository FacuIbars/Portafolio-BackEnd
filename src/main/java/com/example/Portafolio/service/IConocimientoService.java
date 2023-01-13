package com.example.Portafolio.service;

import com.example.Portafolio.model.Conocimiento;
import java.util.List;

public interface IConocimientoService {

    public List<Conocimiento> verConocimientos();

    public void crearConocimiento(Conocimiento cono);

    public void borrarConocimiento(Long id);

    public Conocimiento buscarConocimiento(Long id);
}
