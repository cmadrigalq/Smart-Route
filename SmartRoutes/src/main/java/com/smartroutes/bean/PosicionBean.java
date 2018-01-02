/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.bean;

import com.smartroutes.entity.Posicion;
import com.smartroutes.repository.PosicionRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author jos_c
 */
@Component
@Scope
@ManagedBean(name = "posicionBean")
public class PosicionBean {
    @Autowired
    PosicionRepository posicionRepository;
    Posicion posicion = new Posicion();
    List <Posicion> posiciones;
    
    public void guardar() {
        posicionRepository.save(posicion);
        posicion = new Posicion();
    }
    
    public void seleccionado(SelectEvent event) {
        posicion = (Posicion) event.getObject();
    }
    
    public void deseleccionado(SelectEvent event) {
        posicion = null;
    }

    public Posicion getPosicion() {
        if (posicion == null) {
            posicion = new Posicion();
        }
        return posicion;
    }
    
    public List<Posicion> getPosiciones() {
        posiciones = (List <Posicion>) posicionRepository.findAll();
        return posiciones;
    }
    
    public Posicion prepararCrear() {
        posicion = new Posicion();
        return posicion;
    }
    
    public void borrar() {
        posicionRepository.delete(posicion);
        posicion = null;
    }
    
    public void borrar(Posicion p) {
        posicionRepository.delete(p);
        posicion = null;
    }
    
    public Posicion encontrar(Long id) {
        posicion = posicionRepository.findById(id).get();
        return posicion;
    }
}