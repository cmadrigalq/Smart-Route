package Servicios;

import com.google.gson.Gson;
import entidades.Punto;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

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


    public  List<Punto>getTodosLosPuntos()throws Exception{
        try{
            return  em.createNamedQuery("Punto.findAll", Punto.class)
                    .getResultList();
            
        }catch(Exception ex){
            throw ex;
        }
    }

}
