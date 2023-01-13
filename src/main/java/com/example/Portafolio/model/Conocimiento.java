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

public class Conocimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String lenguaje;
    private long skill;

    public Conocimiento() {
    }

    public Conocimiento(long id, String lenguaje, long skill, String fotos) {
        this.id = id;
        this.lenguaje = lenguaje;
        this.skill = skill;

    }

}
