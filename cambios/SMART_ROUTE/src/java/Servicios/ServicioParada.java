package Servicios;

import entidades.Parada;
import entidades.Posicion;
import java.util.List;

/**
 * ServicioBus:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
public class ServicioParada extends ServicioBase{
public List<Parada> findAll(){
        try{
            return em.createNamedQuery("Parada.findAll", Parada.class)
                    .getResultList();
        }catch(Exception ex){
            throw ex;
        }
    }
}
