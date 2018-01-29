package entidades.modelo;

import entidades.Empresa;
import java.io.Serializable;

/**
 * EmpresaTarifa:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 29/01/2018
 */
public class EmpresaTarifa implements Serializable{
    Empresa empresa;
    int tarifa;

    public EmpresaTarifa(Empresa empresa, int tarifa) {
        this.empresa = empresa;
        this.tarifa = tarifa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }
    
}
