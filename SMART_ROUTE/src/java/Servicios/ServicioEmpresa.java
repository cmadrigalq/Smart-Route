/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import entidades.Empresa;
import java.util.List;


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
