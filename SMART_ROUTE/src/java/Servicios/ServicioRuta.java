/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import entidades.Ruta;
import java.util.List;

/**
 *
 * @author Mario
 */
public class ServicioRuta extends ServicioBase {

    public ServicioRuta() {
        super();
    }

    public List<Ruta> getTodasLasRutas() throws Exception {
        try {
            return em.createNamedQuery("Ruta.findAll", Ruta.class)
                    .getResultList();

        } catch (Exception ex) {
            throw ex;
        }
    }

    public String getListadoRutas1() throws Exception {
        try {
            String sql =  "SELECT "
                    + "GROUP_CONCAT('<option value=\"', "
                    + " b.id,'-','1', "
                    + "        '\">', "
                    + "b.empresa, ': ' ,"
                    + "IFNULL(pt1.descripcion,'?'), ' - ' , "
                    + "IFNULL(pt2.descripcion,'?'), "
                    + "        '</option>' SEPARATOR '\\n') "
                    + "from bus b "
                    + "inner join ruta r "
                    + "on b.ruta1 = r.nombre "
                    + "inner join parada p1  "
                    + "on r.primeraParada = p1.id "
                    + "inner join parada p2 "
                    + "on r.ultimaParada = p2.id "
                    + "inner join punto pt1 "
                    + "on p1.puntoGeografico = pt1.id "
                    + "left join punto pt2 "
                    + "on p2.puntoGeografico = pt2.id";
            return (String)em.createNativeQuery(sql)
                    .getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
    }
    public String getListadoRutas2() throws Exception {
        try {
            String sql =  "SELECT "
                    + "GROUP_CONCAT('<option value=\"', "
                    + " b.id,'-','2', "
                    + "        '\">', "
                    + "b.empresa, ': ' ,"
                    + "IFNULL(pt1.descripcion,'?'), ' - ' , "
                    + "IFNULL(pt2.descripcion,'?'), "
                    + "        '</option>' SEPARATOR '\\n') "
                    + "from bus b "
                    + "inner join ruta r "
                    + "on b.ruta2 = r.nombre "
                    + "inner join parada p1  "
                    + "on r.primeraParada = p1.id "
                    + "inner join parada p2 "
                    + "on r.ultimaParada = p2.id "
                    + "inner join punto pt1 "
                    + "on p1.puntoGeografico = pt1.id "
                    + "left join punto pt2 "
                    + "on p2.puntoGeografico = pt2.id";
            return (String)em.createNativeQuery(sql)
                    .getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
