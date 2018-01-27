/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import entidades.Bus;
import java.util.List;

/**
 *
 * @author Mario
 */
public class ServicioBus extends ServicioBase{
    
    public ServicioBus() {
        super();
    }


    public  List<Bus>getTodosLosBuses()throws Exception{
        try{
            return  em.createNamedQuery("Bus.findAll", Bus.class)
                    .getResultList();
            
        }catch(Exception ex){
            throw ex;
        }
    }
    
   public String listadoDeNombresEmpresas()throws Exception{
        try{
            String sql = "SELECT "
                    + "GROUP_CONCAT('<option value=\"', "
                    + "        p.id, "
                    + "        '\">', "
                    + "        p.empresa,'-', p.ruta1, "
                    + "        '</option>' SEPARATOR '\\n') "
                    + "FROM bus p "
                    + "order by p.empresa";
            return (String)em.createNativeQuery(sql).getSingleResult();
        }catch(Exception ex){
            throw ex;
        }
    }
   
   public Bus getBusByRuta(String Ruta)throws Exception{
        try{
            return  em.createNamedQuery("Bus.findByRuta", Bus.class)
                    .setParameter("ruta", Ruta)
                    .getSingleResult();
        }catch(Exception ex){
            throw ex;
        }
    }     
}