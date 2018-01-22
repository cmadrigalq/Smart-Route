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
    
    protected EntityManager em;
    static final private   EntityManagerFactory EF;
    static final private EntityManager EM;
    static{
        EF = Persistence.createEntityManagerFactory(
                "SMART_ROUTEPU"
        );
        EM = EF.createEntityManager();
    }
    protected ServicioBase(){
        em = ServicioBase.EM;
    }
    
}
