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
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private Date fecha;
    private String info;
    
    @Lob
    private String Img;

    public Educacion() {
    }

    public Educacion(long id, String nombre, Date fecha, String info, String Img) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.info = info;
        this.Img = Img;
    }

}
