/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.entity;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author jos_c
 */
@Entity
@Table(name = "VIAJE")
public class Viaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID_VIAJE")
    private Long id;
    @OneToOne
    @JoinColumn(name = "RUTA", referencedColumnName = "ID_RUTA")
    private Ruta RUTA;
    @OneToOne
    @JoinColumn(name = "PARADA_INICIAL", referencedColumnName = "ID_PARADA_INICIAL")
    private Parada PARADA_INICIAL;
    @OneToOne
    @JoinColumn(name = "PARADA_FINAL", referencedColumnName = "ID_PARADA_FINAL")
    private Parada PARADA_FINAL;
    @OneToOne
    @JoinColumn(name = "HORARIO", referencedColumnName = "ID_HORARIO")
    private Horario HORARIO;
    @OneToOne
    @JoinColumn(name = "BUS", referencedColumnName = "ID_BUS")
    private Bus BUS;

    public Viaje(Long id, Ruta RUTA, Parada PARADA_INICIAL, Parada PARADA_FINAL, Horario HORARIO, Bus BUS) {
        this.id = id;
        this.RUTA = RUTA;
        this.PARADA_INICIAL = PARADA_INICIAL;
        this.PARADA_FINAL = PARADA_FINAL;
        this.HORARIO = HORARIO;
        this.BUS = BUS;
    }

    public Viaje() {
        RUTA = new Ruta();
        PARADA_INICIAL = new Parada();
        PARADA_FINAL = new Parada();
        HORARIO = new Horario();
        BUS = new Bus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ruta getRUTA() {
        return RUTA;
    }

    public void setRUTA(Ruta RUTA) {
        this.RUTA = RUTA;
    }

    public Parada getPARADA_INICIAL() {
        return PARADA_INICIAL;
    }

    public void setPARADA_INICIAL(Parada PARADA_INICIAL) {
        this.PARADA_INICIAL = PARADA_INICIAL;
    }

    public Parada getPARADA_FINAL() {
        return PARADA_FINAL;
    }

    public void setPARADA_FINAL(Parada PARADA_FINAL) {
        this.PARADA_FINAL = PARADA_FINAL;
    }

    public Horario getHORARIO() {
        return HORARIO;
    }

    public void setHORARIO(Horario HORARIO) {
        this.HORARIO = HORARIO;
    }

    public Bus getBUS() {
        return BUS;
    }

    public void setBUS(Bus BUS) {
        this.BUS = BUS;
    }
}
