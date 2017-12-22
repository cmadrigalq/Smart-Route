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
@Table(name = "RUTA")
public class Ruta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID_RUTA")
    private Long id;
    @OneToOne
    @JoinColumn(name = "TARIFA", referencedColumnName = "ID_TARIFA")
    private Tarifa TARIFA;

    public Ruta(Long id, Tarifa TARIFA) {
        this.id = id;
        this.TARIFA = TARIFA;
    }

    public Ruta() {
        TARIFA = new Tarifa();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tarifa getTARIFA() {
        return TARIFA;
    }

    public void setTARIFA(Tarifa TARIFA) {
        this.TARIFA = TARIFA;
    }
}
