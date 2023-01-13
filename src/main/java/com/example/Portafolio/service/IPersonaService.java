package com.example.Portafolio.service;

import com.example.Portafolio.model.Persona;
import java.util.List;

public interface IPersonaService {

    public List<Persona> verPersonas();

    public void crearPersona(Persona per);

    public Persona buscarPersona(Long id);

}
