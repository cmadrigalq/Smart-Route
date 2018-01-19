/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import com.google.gson.Gson;
import entidades.Ruta;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Mario
 */
public class ServicioRuta extends ServicioBase {
    public ServicioRuta(){
        super();
    }
   
    public  List<Ruta>getTodasLasRutas()throws Exception{
        try{
            return  em.createNamedQuery("Ruta.findAll", Ruta.class)
                    .getResultList();
            
        }catch(Exception ex){
            throw ex;
        }
    }
    
}
