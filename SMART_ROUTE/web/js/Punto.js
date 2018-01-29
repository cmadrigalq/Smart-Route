/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global markerOrigen, markerDestino */

class Punto {
    constructor(id, latitud, longitud, paradaList, descripcion) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.paradaList = paradaList;
        this.descripcion = descripcion;

    }

    getPosicion() {
        return {
            lat: this.latitud,
            lng: this.longitud
        };
    }

    marcarUnPunto() {
        let info = new google.maps.InfoWindow({map: map});
        info.setPosition(this.getPosicion());
        info.setContent(
                this.id + " " + this.descripcion
                );
    }
    marcaRoja(direccion) {
        if (direccion === "Destino") {
            this.setDestino();
        } else {
            this.setOrigen();
        }
    }
    setOrigen() {
        Punto.ocultarOrigen();
        markerOrigen = this.crearMarca("Origen seleccionado");
    }
    setDestino() {
        Punto.ocultarDestino();
        markerDestino = this.crearMarca("Destino seleccionado");
    }

    static ocultarPuntos() {
        Punto.ocultarOrigen();
        Punto.ocultarDestino();
    }
    static ocultarOrigen() {
        if (markerOrigen !== null && markerOrigen !== undefined)
            markerOrigen.setVisible(false);
    }
    static ocultarDestino() {
        if (markerDestino !== null && markerDestino !== undefined)
            markerDestino.setVisible(false);
    }
    crearMarca(texto) {
        return new google.maps.Marker({
            map: map,
            draggable: false,
            animation: google.maps.Animation.DROP,
            position: this.getPosicion(),
            title: texto
        });
    }

    static marcarTodos() {
        Proxy("SMART",
                "todosLosPuntos",
                "GET",
                (res) => {
            if (res === null || res === undefined || !Array.isArray(res)) {
                alert(res);
            } else {
                res.forEach(e => e.marcarUnPunto());
            }
        }, );
    }
    static buscarPunto(id, direccion) {
        Proxy("SMART",
                "buscarPunto",
                "POST",
                (res) => {
            if (res === null || res === undefined || !(res instanceof Punto)) {
                alert(res);
            } else {
                res.marcaRoja(direccion);
            }
        }, id);
    }

}
