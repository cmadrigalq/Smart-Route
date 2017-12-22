/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.bean;

import com.smartroutes.entity.Horario;
import com.smartroutes.repository.HorarioRepository;
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
@ManagedBean(name = "horarioBean")
public class HorarioBean {
    @Autowired
    HorarioRepository horarioRepository;
    Horario horario = new Horario();
    List <Horario> horarios;
    
    public void guardar() {
        horarioRepository.save(horario);
        
        horario = new Horario();
    }
    
    public void seleccionado(SelectEvent event) {
        horario = (Horario) event.getObject();
    }
    
    public void deseleccionado(SelectEvent event) {
        horario = null;
    }

    public Horario getHorario() {
        if (horario == null) {
            horario = new Horario();
        }
        return horario;
    }
    
    public List<Horario> getHorarios() {
        horarios = (List <Horario>) horarioRepository.findAll();
        return horarios;
    }
    
    public Horario prepararCrear() {
        horario = new Horario();
        return horario;
    }
    
    public void borrar() {
        horarioRepository.delete(horario);
        horario = null;
    }
    
    public void borrar(Horario h) {
        horarioRepository.delete(h);
        horario = null;
    }
    
    public Horario encontrar(Long id) {
        horario = horarioRepository.findById(id).get();
        return horario;
    }
}