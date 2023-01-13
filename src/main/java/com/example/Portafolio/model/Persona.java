package com.example.Portafolio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String nombre;

    @Lob
   
    private String sobreMi;
    @Lob
    
    private String foto;
    @Lob
   
    private String portada;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Experiencia> experiencias;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Educacion> educacion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Conocimiento> HabilidadesDuras;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<HabilidadBlanda> habilidadesBlandas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Proyecto> proyecto;

    public Persona() {
    }

    public Persona(long id, String nombre, String sobreMi, String foto, String portada) {
        this.id = id;
        this.nombre = nombre;
        this.sobreMi = sobreMi;
        this.foto = foto;
        this.portada = portada;

    }

}
