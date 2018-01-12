package Utilitarios;
/**
 * StringUtil:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 11/01/2018
 */
public class StringUtil {
    public static String LPAD(String origen,int largoFinal,char relleno){
        while(origen.length() < largoFinal){
            origen = relleno + origen;
        }
        return origen;
    }
}
