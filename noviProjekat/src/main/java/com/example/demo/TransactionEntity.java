package com.example.demo;

import lombok.*;

import javax.persistence.*;
import java.time.*;

@Entity
    @Table(name = "transaction_entity")
    public class TransactionEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column
        private Boolean izlaznaTransakcija;

    @Column
    private Boolean ulaznaTransakcija;

        @Column
        private Long iznos;


        @Column
        private String opisProizvoda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIzlaznaTransakcija() {
        return izlaznaTransakcija;
    }

    public void setIzlaznaTransakcija(Boolean izlaznaTransakcija) {
        this.izlaznaTransakcija = izlaznaTransakcija;
    }

    public Boolean getUlaznaTransakcija() {
        return ulaznaTransakcija;
    }

    public void setUlaznaTransakcija(Boolean ulaznaTransakcija) {
        this.ulaznaTransakcija = ulaznaTransakcija;
    }

    public Long getIznos() {
        return iznos;
    }

    public void setIznos(Long iznos) {
        this.iznos = iznos;
    }

    public String getOpisProizvoda() {
        return opisProizvoda;
    }

    public void setOpisProizvoda(String opisProizvoda) {
        this.opisProizvoda = opisProizvoda;
    }

    public TransactionEntity() {
        }

    }

