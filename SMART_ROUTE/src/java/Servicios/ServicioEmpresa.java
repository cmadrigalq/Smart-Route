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

    public Empresa getByBus(Long bus) throws Exception {
        try {
            String sql = "SELECT e.* FROM bus b "
                    + "inner join empresa e "
                    + "on e.nombre = b.empresa "
                    + "where b.id = :id";
            return (Empresa)em.createNativeQuery(sql, Empresa.class)
                    .setParameter("id",bus)
                    .getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
    }

    
}
