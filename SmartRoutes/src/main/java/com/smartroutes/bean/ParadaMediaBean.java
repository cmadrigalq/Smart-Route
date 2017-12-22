/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.bean;

import com.smartroutes.entity.ParadaMedia;
import com.smartroutes.repository.ParadaMediaRepository;
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
@ManagedBean(name = "paradaMediaBean")
public class ParadaMediaBean {
    @Autowired
    ParadaMediaRepository paradaMediaRepository;
    ParadaMedia paradaMedia = new ParadaMedia();
    List <ParadaMedia> paradasMedias;
    
    public void guardar() {
        paradaMediaRepository.save(paradaMedia);
        paradaMedia = new ParadaMedia();
    }
    
    public void seleccionado(SelectEvent event) {
        paradaMedia = (ParadaMedia) event.getObject();
    }
    
    public void deseleccionado(SelectEvent event) {
        paradaMedia = null;
    }

    public ParadaMedia getParadaMedia() {
        if (paradaMedia == null) {
            paradaMedia = new ParadaMedia();
        }
        return paradaMedia;
    }
    
    public List<ParadaMedia> getParadasMedias() {
        paradasMedias = (List <ParadaMedia>) paradaMediaRepository.findAll();
        return paradasMedias;
    }
    
    public ParadaMedia prepararCrear() {
        paradaMedia = new ParadaMedia();
        return paradaMedia;
    }
    
    public void borrar() {
        paradaMediaRepository.delete(paradaMedia);
        paradaMedia = null;
    }
    
    public void borrar(ParadaMedia p) {
        paradaMediaRepository.delete(p);
        paradaMedia = null;
    }
    
    public ParadaMedia encontrar(Long id) {
        paradaMedia = paradaMediaRepository.findById(id).get();
        return paradaMedia;
    }
}
