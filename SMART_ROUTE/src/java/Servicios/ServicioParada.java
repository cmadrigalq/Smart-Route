/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import entidades.Parada;
import java.util.List;

/**
 *
 * @author Mario
 */
public class ServicioParada extends ServicioBase {

    public ServicioParada() {
        super();
    }

    public List<Parada> getTodasLasParadas() throws Exception {
        try {
            return em.createNamedQuery("Parada.findAll", Parada.class)
                    .getResultList();

        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<String> getParadasByBus(Integer bus) throws Exception {
        try {
            String sql = String.format("SELECT pun.descripcion from ("
                    + "    SELECT par.puntoGeografico, par.id from parada par, ("
                    + "        SELECT ru.primeraParada, ru.ultimaParada from ruta ru, ("
                    + "            SELECT bu.ruta1 from bus bu where bu.id = %s "
                    + "        ) b WHERE ru.nombre = b.ruta1 "
                    + "    ) r where par.id >= r.primeraParada and par.id <= r.ultimaParada "
                    + ") p, punto pun where pun.id = p.puntoGeografico;", bus.toString());
            return em.createNativeQuery(sql)
                    .getResultList();

        } catch (Exception ex) {
            throw ex;
        }
    }
}
