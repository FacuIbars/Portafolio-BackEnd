package com.example.Portafolio.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    @Lob
    private String descripcion;
    private Date fecha;

    public Experiencia() {
    }

    public Experiencia(long id, String nombre, String descripcion, Date periodo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = periodo;
    }

}
