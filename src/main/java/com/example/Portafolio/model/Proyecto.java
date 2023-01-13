package com.example.Portafolio.model;

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

public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    @Lob
    private String descripcion;
    private String resultado;
    private String codigo;

    public Proyecto() {
    }

    public Proyecto(long id, String nombre, String descripcion, String resultado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.resultado = resultado;
    }

}
