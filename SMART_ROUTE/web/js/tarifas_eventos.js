/* global Rutas, valores */

$(document).ready(_ => {
    Rutas.buscarBuses("tablaTarifas",
                                    ["Empresa", "Tarifa"],
                                    ["empresa", "tarifa"],
                                    valores[0], valores[1]);
    
});

