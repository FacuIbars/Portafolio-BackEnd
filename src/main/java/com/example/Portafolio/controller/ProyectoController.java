package com.example.Portafolio.controller;

import com.example.Portafolio.model.Proyecto;
import com.example.Portafolio.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {

    @Autowired
    private IProyectoService proServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/proyecto")
    public ResponseEntity agregarProyecto(@RequestBody Proyecto pro) {
        try {
            proServ.crearProyecto(pro);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ver/proyecto")
    @ResponseBody
    public List<Proyecto> verProyectos() {
        return proServ.verProyectos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}/proyecto")

    public ResponseEntity borrarProyecto(@PathVariable Long id) {
        try {
            proServ.borrarProyecto(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/cambiar/{id}/proyecto")

    public ResponseEntity cambiarProyecto(@PathVariable Long id, @RequestBody Proyecto pr) {
        try {
            Proyecto pro = proServ.buscarProyecto(id);
            pro.setNombre(pr.getNombre());
            pro.setDescripcion(pr.getDescripcion());
            pro.setResultado(pr.getResultado());
            pro.setCodigo(pr.getCodigo());
            proServ.crearProyecto(pro);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ver/proyecto/{id}")
    @ResponseBody
    public ResponseEntity buscarProyecto(@PathVariable Long id) {
        try {
            Proyecto pro = proServ.buscarProyecto(id);

            return new ResponseEntity(pro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
