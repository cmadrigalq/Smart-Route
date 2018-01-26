/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
class Horario {
    constructor(id, hora, bus) {
        this.id = id;
        this.hora = hora;
        this.bus = bus;
    }
    static buscarPorRuta(div, headers, atributos, bus, numDeRuta) {
        Proxy("SMART",
                "buscarPorRuta",
                "POST",
                (res) => {
            if (res === null || res === undefined || !Array.isArray(res)) {
                alert(res);
            } else {
                res = res.map(e=>{
                    e.hora = new Date(e.hora)
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

