package Servicios;

import entidades.Tarifa;
import java.util.List;

/**
 * ServicioBus:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
public class ServicioTarifa extends ServicioBase{
    
    public List<Tarifa> findAll() {
        try {
            return em.createNamedQuery("Tarifa.findAll", Tarifa.class)
                    .getResultList();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
}
