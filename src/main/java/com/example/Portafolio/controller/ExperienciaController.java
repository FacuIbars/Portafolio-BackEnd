package com.example.Portafolio.Controller;

import com.example.Portafolio.model.Experiencia;
import com.example.Portafolio.service.IExperienciaService;
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
public class ExperienciaController {

    @Autowired
    private IExperienciaService ExpeServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/experiencia")
    public ResponseEntity agregarExperiencia(@RequestBody Experiencia Expe) {
        try {
            ExpeServ.crearExperiencia(Expe);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ver/experiencia")
    @ResponseBody
    public List<Experiencia> verExperiencias() {
        return ExpeServ.verExperiencias();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}/experiencia")

    public ResponseEntity borrarExperiencia(@PathVariable Long id) {
        try {
            ExpeServ.borrarExperiencia(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/cambiar/{id}/experiencia")

    public ResponseEntity cambiarExperiencia(@PathVariable Long id, @RequestBody Experiencia Exp) {
        try {
            Experiencia Expe = ExpeServ.buscarExperiencia(id);
            Expe.setNombre(Exp.getNombre());
            Expe.setDescripcion(Exp.getDescripcion());
            Expe.setFecha(Exp.getFecha());
            ExpeServ.crearExperiencia(Expe);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ver/experiencia/{id}")
    @ResponseBody
    public ResponseEntity buscarExperiencia(@PathVariable Long id) {
        try {
            Experiencia Expe = ExpeServ.buscarExperiencia(id);

            return new ResponseEntity(Expe, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
