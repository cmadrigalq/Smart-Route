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
@Table(name = "POSICION")
public class Posicion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID_POS")
    private Long id;
    @Column(name = "LATITUD")
    private Long LATITUD;
    @Column(name = "LONGITUD")
    private Long LONGITUD;

    public Posicion(Long id, Long LATITUD, Long LONGITUD) {
        this.id = id;
        this.LATITUD = LATITUD;
        this.LONGITUD = LONGITUD;
    }

    public Posicion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLATITUD() {
        return LATITUD;
    }

    public void setLATITUD(Long LATITUD) {
        this.LATITUD = LATITUD;
    }

    public Long getLONGITUD() {
        return LONGITUD;
    }

    public void setLONGITUD(Long LONGITUD) {
        this.LONGITUD = LONGITUD;
    }

    @Override
    public String toString() {
        return "Posicion{" + "id=" + id + ", LATITUD=" + LATITUD + ", LONGITUD=" + LONGITUD + '}';
    }
}
