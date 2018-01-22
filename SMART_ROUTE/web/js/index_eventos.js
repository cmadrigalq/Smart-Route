/* global Punto */

$(document).ready(_ => {
    $("#origenBus").change(e => {
        let id = e.target.id;
        let puntoId = $("select[id=" + id + "]").val();
        if (puntoId != 0)
            Punto.buscarPunto(puntoId, "Origen");
    });
    $("#destinoBus").change(e => {
        let id = e.target.id;
        let puntoId = $("select[id=" + id + "]").val();
        if (puntoId != 0)
            Punto.buscarPunto(puntoId, "Destino");
    });
    $("#filtroOrigen").change(e=>{
        ocultarPorFiltro("origenBus",$("#filtroOrigen")[0].value);
    });
    $("#filtroDestino").change(e=>{
        ocultarPorFiltro("destinoBus",$("#filtroDestino")[0].value);
    });
});

