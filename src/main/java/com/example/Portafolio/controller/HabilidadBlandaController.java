package com.example.Portafolio.controller;

import com.example.Portafolio.model.HabilidadBlanda;
import com.example.Portafolio.service.IHabilidadBlandaService;
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
public class HabilidadBlandaController {

    @Autowired
    private IHabilidadBlandaService HabiServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/habilidadBlanda")
    public ResponseEntity agregarHabilidadBlanda(@RequestBody HabilidadBlanda Habi) {
        try {
            HabiServ.crearHabilidadBlanda(Habi);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ver/habilidadBlanda")
    @ResponseBody
    public List<HabilidadBlanda> verHabilidadBlandas() {
        return HabiServ.verHabilidadBlanda();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}/habilidadBlanda")

    public ResponseEntity borrarHabilidadBlanda(@PathVariable Long id) {
        try {
            HabiServ.borrarHabilidadBlanda(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/cambiar/{id}/habilidadBlanda")

    public ResponseEntity cambiarHabilidadBlanda(@PathVariable Long id, @RequestBody HabilidadBlanda hab) {
        try {
            HabilidadBlanda Habi = HabiServ.buscarHabilidadBlanda(id);
            Habi.setHabilidad(hab.getHabilidad());
            Habi.setSkill(hab.getSkill());
            HabiServ.crearHabilidadBlanda(Habi);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ver/habilidadBlanda/{id}")
    @ResponseBody
    public ResponseEntity buscarHabilidadBlanda(@PathVariable Long id) {
        try {
            HabilidadBlanda Habi = HabiServ.buscarHabilidadBlanda(id);

            return new ResponseEntity(Habi, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
