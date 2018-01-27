/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class Bus{
    constructor(id,descripcion,tarifa){
        this.id=id;
        this.descripcion=descripcion;
        this.tarifa=tarifa;
    }
    
    static buscarBuses(div, headers, atributos, bus, numDeRuta) {
        Proxy("SMART",
                "todosLosBuses",
                "POST",
                (res) => {
            if (res === null || res === undefined || !Array.isArray(res)) {
                alert(res);
            } else {
                res = res.map(e=>{
                    e.empresa = new Date(e.hora);
                    return e;
                });
                let tabla = new Table(
                        div, headers, res, atributos
                        );
                tabla.createTable();
            }
        }, bus, numDeRuta);
    }
   
}


