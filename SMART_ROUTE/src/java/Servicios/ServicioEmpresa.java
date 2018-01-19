/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import com.google.gson.Gson;
import entidades.Empresa;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author Mario
 */
public class ServicioEmpresa extends ServicioBase {
    
    public ServicioEmpresa() {
        super();
    }


    public  List<Empresa>getTodasLasEmpresas()throws Exception{
        try{
            return  em.createNamedQuery("Empresa.findAll", Empresa.class)
                    .getResultList();
            
        }catch(Exception ex){
            throw ex;
        }
    }
    
}
