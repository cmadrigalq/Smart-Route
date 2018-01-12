package Servicios;

import entidades.Posicion;
import java.util.List;

/**
 * ServicioBus:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
public class ServicioPosicion extends ServicioBase{

    public ServicioPosicion(){
        super();
    }
    ///***HECHOS CON NAMEDQUERY
    public List<Posicion> findAll(){
        try{
            return em.createNamedQuery("Posicion.findAll", Posicion.class)
                    .getResultList();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public Posicion findById(Integer id){
        try{
            return em.createNamedQuery("Posicion.findByIdPos", Posicion.class)
                    .setParameter("idPos", id)
                    .getSingleResult();
        }catch(Exception ex){
            throw ex;
        }    
    }
    
    ///HECHOS CON JQL 
    /**
     * 
     * @param lat
     * @param lon
     * @return  los pts en un rango a la redonda
     */
    public List<Posicion> getLatLongAprox(Integer lat, Integer lon) {
        try {
            String jql = "SELECT p FROM POSICION p "
                    + " where p.latitud >= :par1 + 0.005  AND p.latitud <= :par2 - 0.005 "
                    + " AND   p.longitud >= :par3 + 0.005  AND p.longitud <= :par4 - 0.005 ";

             return em.createQuery(jql,Posicion.class)
                     .setParameter("par1", lat)
                     .setParameter("par2", lat)
                     .setParameter("par3", lon)
                     .setParameter("par4", lon)
                     .getResultList();
        }catch(Exception ex){
            throw ex;
        }
    }
    
}





