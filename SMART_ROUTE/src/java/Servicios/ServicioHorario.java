/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import entidades.Horario;
import java.util.List;

/**
 *
 * @author Mario
 */
public class ServicioHorario extends ServicioBase {
    
    public ServicioHorario() {
        super();
    }


    public  List<Horario>getTodosLosHorarios()throws Exception{
        try{
            return  em.createNamedQuery("Horario.findAll", Horario.class)
                    .getResultList();
            
        }catch(Exception ex){
            throw ex;
        }
    }
    
}
