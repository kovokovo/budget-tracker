package com.example.racun;

import javax.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "racun")
public class Racun {

    @javax.persistence.Id
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="mjesecni_limit")
    private Long mjesecniLimit;

    @Column(name="trenutno_stanje")
    private Long trenutnoStanje;

    @Column(name="racun_limit")
    private Long racunLimit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMjesecniLimit() {
        return mjesecniLimit;
    }

    public void setMjesecniLimit(Long mjesecniLimit) {
        this.mjesecniLimit = mjesecniLimit;
    }

    public Long getTrenutnoStanje() {
        return trenutnoStanje;
    }

    public void setTrenutnoStanje(Long trenutnoStanje) {
        this.trenutnoStanje = trenutnoStanje;
    }

    public Long getRacunLimit() {
        return racunLimit;
    }

    public void setRacunLimit(Long limit) {
        this.racunLimit = limit;
    }

}
