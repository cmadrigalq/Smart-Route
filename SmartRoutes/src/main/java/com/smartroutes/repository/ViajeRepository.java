/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartroutes.repository;

import com.smartroutes.entity.Viaje;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jos_c
 */
public interface ViajeRepository extends CrudRepository<Viaje, Long> {
    
}
