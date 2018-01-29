/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


class Empresa {
    constructor(nombre, telefono, link) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.link = link;
    }
    static buscarEmpresaPorBus(bus){
        if(bus === null || bus === undefined){
            return;
        }
        Proxy("SMART",
                "buscaInfoEmpresaByBus",
                "POST",
                (res) => {
            if (res === null || res === undefined || !(res instanceof EmpresaTarifa)) {
                alert(res);
            } else {
                res.empresa.mostrarInformacion();
                 $("#tarifaDelBus")[0].innerHTML = "Tarifa: ₡ " + res.tarifa;
            }
        }, bus);
    }
    mostrarInformacion() {
        $("#nombreEmpresa")[0].innerHTML = "Empresa: " + this.nombre;

        $("#infoEmpresa").show();
        if (this.telefono === null || this.telefono === undefined) {
            $("#numeroEmpresa").hide();
        } else
            $("#numeroEmpresa")[0].innerHTML = "Numero telefónico: " + this.telefono;

        if (this.link === null || this.link === undefined) {
            $("#linkEmpresa").hide();
        } else
            $("#linkEmpresa")[0].innerHTML = `<a href="${this.link}">${this.link}</a>`;
    }
}