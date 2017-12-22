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
import javax.persistence.Table;

/**
 *
 * @author jos_c
 */
@Entity
@Table(name = "PARADA_MEDIA")
public class ParadaMedia implements Serializable {

     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID_PARADA_M")
    private Long id;
    @Column(name = "LUGAR")
    private String LUGAR;
    @Column(name = "VIAJE")
    private Viaje VIAJE;

    public ParadaMedia(Long id, String LUGAR, Viaje VIAJE) {
        this.id = id;
        this.LUGAR = LUGAR;
        this.VIAJE = VIAJE;
    }

    public ParadaMedia() {
        VIAJE = new Viaje();
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
}
