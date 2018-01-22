const match = (valor, criterio) => {
    valor = valor.toUpperCase().trim(); 
    criterio = criterio.toUpperCase().trim(); 
    return criterio.split(" ")
            .every(
                    palabra => valor.includes(palabra)
            );
};
const ocultarPorFiltro = (opciones, criterio) => {
    $("#" + opciones).children()
            .toArray()
            .forEach(
                    e => {
                        if (match(e.innerHTML, criterio)) {
                            $(e).show();
                        } else {
                            $(e).hide();
                        }
                    }
            );
};
