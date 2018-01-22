/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import entidades.Parada;
import java.util.List;

/**
 *
 * @author Mario
 */
public class ServicioParada extends ServicioBase {
    
    public ServicioParada() {
        super();
    }


    public  List<Parada>getTodasLasParadas()throws Exception{
        try{
            return  em.createNamedQuery("Parada.findAll", Parada.class)
                    .getResultList();
            
        }catch(Exception ex){
            throw ex;
        }
    }
    
}
