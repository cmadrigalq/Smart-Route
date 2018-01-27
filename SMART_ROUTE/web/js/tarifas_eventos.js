/*  Ruta */

/* global Ruta, valores */

$(document).ready(_ => {
    Ruta.buscarBuses("tablaTarifas",
            ["Empresa", "Tarifa"],
            ["empresa", "tarifa"],
            valores[0], valores[1]);

});

