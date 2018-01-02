/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.bean;

import com.smartroutes.entity.Parada;
import com.smartroutes.entity.Posicion;
import com.smartroutes.repository.ParadaRepository;
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
@ManagedBean(name = "mapaBean")
public class MapaBean {
    @Autowired
    ParadaRepository paradaRepository;
    Parada parada = new Parada();
    List <Parada> paradas;
    PosicionRepository posicionRepository;
    Posicion posicion = new Posicion();
    List <Posicion> posiciones;
    
    public void guardar() {
        paradaRepository.save(parada);
        parada = new Parada();
    }
    
    public void seleccionado(SelectEvent event) {
        parada = (Parada) event.getObject();
    }
    
    public void deseleccionado(SelectEvent event) {
        parada = null;
    }

    public Parada getParada() {
        if (parada == null) {
            parada = new Parada();
        }
        return parada;
    }
    
    public List<Parada> getParadas() {
        paradas = (List <Parada>) paradaRepository.findAll();
        return paradas;
    }
    
    public Parada prepararCrear() {
        parada = new Parada();
        return parada;
    }
    
    public void borrar() {
        paradaRepository.delete(parada);
        parada = null;
    }
    
    public void borrar(Parada p) {
        paradaRepository.delete(p);
        parada = null;
    }
    
    public Parada encontrar(Long id) {
        parada = paradaRepository.findById(id).get();
        return parada;
    }
}