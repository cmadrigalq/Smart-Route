/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import com.google.gson.Gson;
import entidades.Bus;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

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
    
}
