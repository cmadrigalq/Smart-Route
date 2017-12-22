/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.bean;

import com.smartroutes.entity.Ruta;
import com.smartroutes.entity.Viaje;
import com.smartroutes.repository.ViajeRepository;
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
@ManagedBean(name = "viajeBean")
public class ViajeBean {
    @Autowired
    ViajeRepository viajeRepository;
    Viaje viaje = new Viaje();
    List <Viaje> viajes;
    
    public void guardar() {
        viajeRepository.save(viaje);
        viaje = new Viaje();
    }
    
    public void seleccionado(SelectEvent event) {
        viaje = (Viaje) event.getObject();
    }
    
    public void deseleccionado(SelectEvent event) {
        viaje = null;
    }

    public Viaje getViaje() {
        if (viaje == null) {
            viaje = new Viaje();
        }
        return viaje;
    }
    
    public List<Viaje> getViajes() {
        viajes = (List <Viaje>) viajeRepository.findAll();
        return viajes;
    }
    
    public Viaje prepararCrear() {
        viaje = new Viaje();
        return viaje;
    }
    
    public void borrar() {
        viajeRepository.delete(viaje);
        viaje = null;
    }
    
    public void borrar(Viaje v) {
        viajeRepository.delete(v);
        viaje = null;
    }
    
    public Viaje encontrar(Long id) {
        viaje = viajeRepository.findById(id).get();
        return viaje;
    }
}
