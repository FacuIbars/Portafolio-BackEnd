package com.example.Portafolio.controller;

import com.example.Portafolio.model.Persona;
import com.example.Portafolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private IPersonaService persoServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/cambiar/{id}/persona")

    public void cambiarPersona(@PathVariable Long id, @RequestBody Persona per) {
        Persona pers = persoServ.buscarPersona(id);
        pers.setNombre(per.getNombre());
        pers.setSobreMi(per.getSobreMi());
        pers.setFoto(per.getFoto());
        pers.setPortada(per.getPortada());

        persoServ.crearPersona(pers);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona pers) {
        persoServ.crearPersona(pers);

    }

    @GetMapping("/ver/persona")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoServ.verPersonas();
    }

    @GetMapping("/ver/persona/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable Long id) {
        return persoServ.buscarPersona(id);
    }

}
