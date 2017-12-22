/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.bean;

import com.smartroutes.entity.Bus;
import com.smartroutes.repository.BusRepository;
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
@ManagedBean(name = "busBean")
public class BusBean {
    @Autowired
    BusRepository busRepository;
    Bus bus = new Bus();
    List <Bus> buses;
    
    public void guardar() {
        busRepository.save(bus);
        bus = new Bus();
    }
    
    public void seleccionado(SelectEvent event) {
        bus = (Bus) event.getObject();
    }
    
    public void deseleccionado(SelectEvent event) {
        bus = null;
    }

    public Bus getBus() {
        if (bus == null) {
            bus = new Bus();
        }
        return bus;
    }
    
    public List<Bus> getBuses() {
        buses = (List <Bus>) busRepository.findAll();
        return buses;
    }
    
    public Bus prepararCrear() {
        bus = new Bus();
        return bus;
    }
    
    public void borrar() {
        busRepository.delete(bus);
        bus = null;
    }
    
    public void borrar(Bus b) {
        busRepository.delete(b);
        bus = null;
    }
    
    public Bus encontrar(Long id) {
        bus = busRepository.findById(id).get();
        return bus;
    }
}