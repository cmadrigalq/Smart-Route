/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import com.google.gson.Gson;
import entidades.Horario;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

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
