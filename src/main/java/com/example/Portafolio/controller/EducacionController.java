package com.example.Portafolio.controller;

import com.example.Portafolio.model.Educacion;
import com.example.Portafolio.service.IEducacionService;
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
public class EducacionController {

    @Autowired
    private IEducacionService eduServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/educacion")
    public ResponseEntity agregarEducacion(@RequestBody Educacion edu) {
        try {
            eduServ.CrearEducacion(edu);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ver/educacion")
    @ResponseBody
    public List<Educacion> verEducacions() {
        return eduServ.verEducacion();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}/educacion")

    public ResponseEntity borrarEducacion(@PathVariable Long id) {
        try {
            eduServ.borrarEducacion(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/cambiar/{id}/educacion")

    public ResponseEntity cambiarEducacion(@PathVariable Long id, @RequestBody Educacion ed) {
        try {
            Educacion edu = eduServ.buscarEducacion(id);
            edu.setNombre(ed.getNombre());
            edu.setFecha(ed.getFecha());
            edu.setInfo(ed.getInfo());
            edu.setImg(ed.getImg());
            eduServ.CrearEducacion(edu);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ver/educacion/{id}")
    @ResponseBody
    public ResponseEntity buscarEducacion(@PathVariable Long id) {
        try {
            Educacion edu = eduServ.buscarEducacion(id);

            return new ResponseEntity(edu, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
