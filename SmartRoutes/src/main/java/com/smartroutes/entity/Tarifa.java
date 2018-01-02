/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "TARIFA")
public class Tarifa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID_TARIFA")
    private Long id;
    @Column(name = "TARIFA")
    private int TARIFA;
    @Column(name = "INICIO")
    private Date INICIO;

    public Tarifa(Long id, int TARIFA, Date INICIO) {
        this.id = id;
        this.TARIFA = TARIFA;
        this.INICIO = INICIO;
    }

    public Tarifa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTARIFA() {
        return TARIFA;
    }

    public void setTARIFA(int TARIFA) {
        this.TARIFA = TARIFA;
    }

    public Date getINICIO() {
        return INICIO;
    }

    public void setINICIO(Date INICIO) {
        this.INICIO = INICIO;
    }

    @Override
    public String toString() {
        return "Tarifa{" + "id=" + id + ", TARIFA=" + TARIFA + ", INICIO=" + INICIO + '}';
    }
}
