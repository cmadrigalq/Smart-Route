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

const dateToText=(date,pattern = "`${hh}:${mm} ${apm}`")=>{
    if(!(date instanceof Date))
        return dateToText(new Date());
    let hh = date.getHours();
    let apm;
    if(hh >= 12){
        apm = "pm";
    }else apm = "am";
    hh %= 13;
    if(hh < 10){
        hh = '0'+hh;
    }
    let mm = date.getMinutes();
    if(mm < 10){
        mm = '0'+mm;
    }
    return eval(pattern);
};  
