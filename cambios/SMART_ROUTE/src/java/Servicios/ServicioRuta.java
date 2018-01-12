package Servicios;

import entidades.Ruta;
import java.util.List;

/**
 * ServicioBus:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
public class ServicioRuta extends ServicioBase{
public List<Ruta> findAll(){
        try{
            return em.createNamedQuery("Ruta.findAll", Ruta.class)
                    .getResultList();
        }catch(Exception ex){
            throw ex;
        }
    }
}
