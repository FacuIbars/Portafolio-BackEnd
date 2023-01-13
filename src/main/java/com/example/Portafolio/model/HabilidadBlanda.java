package com.example.Portafolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HabilidadBlanda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Habilidad;
    private long skill;

    public HabilidadBlanda() {
    }

    public HabilidadBlanda(long id, String Habilidad, long skill) {
        this.id = id;
        this.Habilidad = Habilidad;
        this.skill = skill;
    }

}
