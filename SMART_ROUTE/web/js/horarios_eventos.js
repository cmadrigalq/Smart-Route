/*  puntoId, Horario */

/* global Horario */

$(document).ready(_ => {
    $("#filtroRutas").change(e=>{
        ocultarPorFiltro("rutasOpciones",$("#filtroRutas")[0].value);
    });
    $("#buscar").click(e=>{
        let id = e.target.id;
        let ruta = $("select[id=rutasOpciones]").val();
        let valores = ruta.split("-");
        if (ruta != 0)
            Horario.buscarPorRuta("tablaHorarios",
                                    ["Hora de salida."],
                                    ["hora"],
                                    valores[0], valores[1]);
    });
    
});

