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
@Table(name = "BUS")
public class Bus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID_BUS")
    private Long id;
    @Column(name = "NOMBRE")
    private String NOMBRE;
    @Column(name = "CANT_PASAJEROS")
    private int CANT_PASAJEROS;

    public Bus(Long id, String NOMBRE, int CANT_PASAJEROS) {
        this.id = id;
        this.NOMBRE = NOMBRE;
        this.CANT_PASAJEROS = CANT_PASAJEROS;
    }

    public Bus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getCANT_PASAJEROS() {
        return CANT_PASAJEROS;
    }

    public void setCANT_PASAJEROS(int CANT_PASAJEROS) {
        this.CANT_PASAJEROS = CANT_PASAJEROS;
    }

    @Override
    public String toString() {
        return "Bus{" + "id=" + id + ", NOMBRE=" + NOMBRE + ", CANT_PASAJEROS=" + CANT_PASAJEROS + '}';
    }
}
