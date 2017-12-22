/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.bean;

import com.smartroutes.entity.Tarifa;
import com.smartroutes.repository.TarifaRepository;
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
@ManagedBean(name = "tarifaBean")
public class TarifaBean {

    @Autowired
    TarifaRepository tarifaRepository;
    Tarifa tarifa = new Tarifa();
    List<Tarifa> tarifas;

    public void guardar() {
        tarifaRepository.save(tarifa);
        tarifa = new Tarifa();
    }

    public void seleccionado(SelectEvent event) {
        tarifa = (Tarifa) event.getObject();
    }

    public void deseleccionado(SelectEvent event) {
        tarifa = null;
    }

    public Tarifa getTarifa() {
        if (tarifa == null) {
            tarifa = new Tarifa();
        }
        return tarifa;
    }

    public List<Tarifa> getTarifas() {
        tarifas = (List<Tarifa>) tarifaRepository.findAll();
        return tarifas;
    }

    public Tarifa prepararCrear() {
        tarifa = new Tarifa();
        return tarifa;
    }

    public void borrar() {
        tarifaRepository.delete(tarifa);
        tarifa = null;
    }

    public void borrar(Tarifa t) {
        tarifaRepository.delete(t);
        tarifa = null;
    }

    public Tarifa encontrar(Long id) {
        tarifa = tarifaRepository.findById(id).get();
        return tarifa;
    }
}
