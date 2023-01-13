package com.example.Portafolio.service;

import com.example.Portafolio.model.Educacion;

import java.util.List;

public interface IEducacionService {

    public List<Educacion> verEducacion();

    public void CrearEducacion(Educacion edu);

    public void borrarEducacion(Long id);

    public Educacion buscarEducacion(Long id);

}
