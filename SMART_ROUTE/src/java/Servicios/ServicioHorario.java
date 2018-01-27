/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import entidades.Horario;
import java.util.Date;
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
    public  List<Horario>getByBusYRuta(Long bus,String ruta)throws Exception{
        try{
            String sql = "SELECT * FROM horario h "
                    + "WHERE h.isRuta1 = :isRuta1 "
                    + "and h.Bus = :bus";
            return  em.createNativeQuery(sql,Horario.class)
                    .setParameter("isRuta1",ruta.trim().equals("1"))
                    .setParameter("bus",bus)
                    .getResultList();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public  List<Horario> getHorariosByBus(Long Bus)throws Exception{
        try{
            String sql = "SELECT * FROM horario h "
                    + "WHERE h.bus = :Bus ";
            return  em.createNativeQuery(sql,Horario.class)
                    .setParameter("Bus",Bus)
                    .getResultList();
        }catch(Exception ex){
            throw ex;
        }
    }
}
