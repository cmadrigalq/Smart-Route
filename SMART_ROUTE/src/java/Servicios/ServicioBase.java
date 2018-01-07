package Servicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * ServicioBase:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
public class ServicioBase {
    
    private   EntityManagerFactory ef;
    protected EntityManager em;
    protected ServicioBase(){
        ef = Persistence.createEntityManagerFactory(
                "SMART_ROUTEPU"
        );
        em = ef.createEntityManager();
    }
    
}
