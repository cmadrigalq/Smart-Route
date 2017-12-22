/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.bean;

import com.smartroutes.entity.Ruta;
import com.smartroutes.repository.RutaRepository;
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
@ManagedBean(name = "rutaBean")
public class RutaBean {
    @Autowired
    RutaRepository rutaRepository;
    Ruta ruta = new Ruta();
    List <Ruta> rutas;
    
    public void guardar() {
        rutaRepository.save(ruta);
        ruta = new Ruta();
    }
    
    public void seleccionado(SelectEvent event) {
        ruta = (Ruta) event.getObject();
    }
    
    public void deseleccionado(SelectEvent event) {
        ruta = null;
    }

    public Ruta getRuta() {
        if (ruta == null) {
            ruta = new Ruta();
        }
        return ruta;
    }
    
    public List<Ruta> getRutas() {
        rutas = (List <Ruta>) rutaRepository.findAll();
        return rutas;
    }
    
    public Ruta prepararCrear() {
        ruta = new Ruta();
        return ruta;
    }
    
    public void borrar() {
        rutaRepository.delete(ruta);
        ruta = null;
    }
    
    public void borrar(Ruta r) {
        rutaRepository.delete(r);
        ruta = null;
    }
    
    public Ruta encontrar(Long id) {
        ruta = rutaRepository.findById(id).get();
        return ruta;
    }
}
