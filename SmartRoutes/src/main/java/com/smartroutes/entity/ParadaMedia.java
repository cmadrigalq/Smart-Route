/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.entity;

import java.io.Serializable;
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
@Table(name = "PARADAMEDIA")
public class ParadaMedia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID_PARADA_M")
    private Long id;
    @Column(name = "LUGAR")
    private String LUGAR;
    @OneToOne
    @JoinColumn(name = "VIAJE", referencedColumnName = "ID_VIAJE")
    private Viaje VIAJE;
    @OneToOne
    @JoinColumn(name = "POSICION", referencedColumnName = "ID_POS")
    private Posicion POSICION;

    public ParadaMedia(Long id, String LUGAR, Viaje VIAJE, Posicion POSICION) {
        this.id = id;
        this.LUGAR = LUGAR;
        this.VIAJE = VIAJE;
        this.POSICION = POSICION;
    }

    public ParadaMedia() {
        VIAJE = new Viaje();
        POSICION = new Posicion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLUGAR() {
        return LUGAR;
    }

    public void setLUGAR(String LUGAR) {
        this.LUGAR = LUGAR;
    }

    public Viaje getVIAJE() {
        return VIAJE;
    }

    public void setVIAJE(Viaje VIAJE) {
        this.VIAJE = VIAJE;
    }
    
    public Posicion getPOSICION() {
        return POSICION;
    }

    public void setPOSICION(Posicion POSICION) {
        this.POSICION = POSICION;
    }

    @Override
    public String toString() {
        return "ParadaMedia{" + "id=" + id + ", LUGAR=" + LUGAR + ", VIAJE=" + VIAJE + ", POSICION=" + POSICION + '}';
    }
}
