package Servicios;

import entidades.Horario;
import java.util.List;


/**
 * ServicioBus:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
public class ServicioHorario extends ServicioBase{
    
    public List<Horario> findAll(){
        try{
            return em.createNamedQuery("Horario.findAll", Horario.class)
                    .getResultList();
        }catch(Exception ex){
            throw ex;
        }
    }

}
