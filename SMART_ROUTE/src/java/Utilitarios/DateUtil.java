package Utilitarios;

import java.util.Date;

/**
 * DateUtil:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 11/01/2018
 */
public class DateUtil {    
    public static String toHora(Date d){
        if(d == null)
            return "??:??";
        Integer mins = d.getMinutes(),
            hora =  d.getHours() % 13;
        String am_pm;
        if(hora > 11){
            am_pm = "pm.";
        }else {
            am_pm = "am.";
        }
        return String.format(
                "%s:%s %s",
                StringUtil.LPAD(hora.toString(),2,'0'),
                StringUtil.LPAD(mins.toString(),2,'0'),
                am_pm);
    }
}
