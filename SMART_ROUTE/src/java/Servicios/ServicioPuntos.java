package Servicios;

import entidades.Punto;
import java.util.List;

/**
 * ServicioPuntos:
 *
 * @version 1.0.0
 * @author Cynthia Madrigal Quesada
 * @date 15/01/2018
 */
public class ServicioPuntos extends ServicioBase {

    public ServicioPuntos() {
        super();
    }

    public Punto getPuntoById(Long id) throws Exception {
        try {
            return em.createNamedQuery("Punto.findById", Punto.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
    }

    
    public  List<Punto>getTodosLosPuntos()throws Exception{
        try{
            return  em.createNamedQuery("Punto.findAll", Punto.class)
                    .getResultList();
            
        }catch(Exception ex){
            throw ex;
        }
    }
    public String listadoDeDescripciones()throws Exception{
        try{
            String sql = "SELECT "
                    + "GROUP_CONCAT('<option value=\"', "
                    + "        p.id, "
                    + "        '\">', "
                    + "        p.descripcion, "
                    + "        '</option>' SEPARATOR '\\n') "
                    + "FROM punto p "
                    + "order by p.descripcion";
            return (String)em.createNativeQuery(sql).getSingleResult();
        }catch(Exception ex){
            throw ex;
        }
    }

}
