package com.example.Portafolio.controller;

import com.example.Portafolio.model.Conocimiento;
import com.example.Portafolio.service.IConocimientoService;
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
public class ConocimienoController {

    @Autowired
    private IConocimientoService ConoServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/conocimiento")
    public ResponseEntity agregarConocimiento(@RequestBody Conocimiento Cono) {
        try {
            ConoServ.crearConocimiento(Cono);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ver/conocimiento")
    @ResponseBody
    public List<Conocimiento> verConocimientos() {
        return ConoServ.verConocimientos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}/conocimiento")

    public ResponseEntity borrarConocimiento(@PathVariable Long id) {
        try {
            ConoServ.borrarConocimiento(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/cambiar/{id}/conocimiento")

    public ResponseEntity cambiarConocimiento(@PathVariable Long id, @RequestBody Conocimiento Con) {
        try {
            Conocimiento cono = ConoServ.buscarConocimiento(id);
            cono.setLenguaje(Con.getLenguaje());
            cono.setSkill(Con.getSkill());
            ConoServ.crearConocimiento(cono);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ver/conocimiento/{id}")
    @ResponseBody
    public ResponseEntity buscarConocimiento(@PathVariable Long id) {
        try {
            Conocimiento Cono = ConoServ.buscarConocimiento(id);

            return new ResponseEntity(Cono, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
