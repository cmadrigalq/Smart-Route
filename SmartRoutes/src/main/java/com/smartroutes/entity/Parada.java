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
@Table(name = "PARADA")
public class Parada implements Serializable {

     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID_PARADA")
    private Long id;
    @Column(name = "LUGAR")
    private String LUGAR;
    @OneToOne
    @JoinColumn(name = "POSICION", referencedColumnName = "ID_POS")
    private Posicion POSICION;

    public Parada(Long id, String LUGAR, Bus BUS, Posicion POSICION) {
        this.id = id;
        this.LUGAR = LUGAR;
        this.POSICION = POSICION;
    }

    public Parada() {
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
    
    public Posicion getPOSICION() {
        return POSICION;
    }

    public void setPOSICION(Posicion POSICION) {
        this.POSICION = POSICION;
    }

    @Override
    public String toString() {
        return "Parada{" + "id=" + id + ", LUGAR=" + LUGAR + ", POSICION=" + POSICION + '}';
    }
}
