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
import javax.persistence.Temporal;

/**
 *
 * @author jos_c
 */
@Entity
@Table(name = "HORARIO")
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID_HORARIO")
    private Long id;
    @Column(name = "HORA_SALIDA")
    private Date HORA_SALIDA;
    @Column(name = "HORA_LLEGAD")
    private Date HORA_LLEGAD;

    public Horario(Long id, Date HORA_SALIDA, Date HORA_LLEGAD) {
        this.id = id;
        this.HORA_SALIDA = HORA_SALIDA;
        this.HORA_LLEGAD = HORA_LLEGAD;
    }

    public Horario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHORA_SALIDA() {
        return HORA_SALIDA;
    }

    public void setHORA_SALIDA(Date HORA_SALIDA) {
        this.HORA_SALIDA = HORA_SALIDA;
    }

    public Date getHORA_LLEGAD() {
        return HORA_LLEGAD;
    }

    public void setHORA_LLEGAD(Date HORA_LLEGAD) {
        this.HORA_LLEGAD = HORA_LLEGAD;
    }

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", HORA_SALIDA=" + HORA_SALIDA + ", HORA_LLEGAD=" + HORA_LLEGAD + '}';
    }
}
