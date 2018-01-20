/**
 Cynthia Madrigal Quesada. 10:20pm
 Clase encargada de administrar las peticiones
 
 */

const jsonFromObject = (k, object) => {
    /*si no es un objeto lo devuelve sin hacer nada*/
    if ((!(object instanceof Object)) || object === null || object === undefined) {
        return object;
    }
    /**Sino, extrae los atributos del objeto y crea un objeto anonimo 
     con el _class correspondiente al className del objeto
     */
    return Object.keys(object)
            .reduce((json, atributo) => {
                json[atributo] = object[atributo];
                return json;
            }, {
                _class: object.constructor.name
            });
};


const objectFromJson = (k, json) => {
    if (json === null || json === undefined || json._class === undefined) {
        return json;
    }
    //crea un objeto dependiendo del atributo _class del json
    return Object.keys(json)
            .reduce((obj, atributo) => {
                if (atributo != "_class")
                    obj[atributo] = json[atributo];
                return obj;
            }, eval(`new ${json._class}()`));
};

const toJson = object => {
    return JSON.stringify(object, jsonFromObject);
};
const toObject = (jsonText, _class) => {
    let obj = JSON.parse(jsonText, objectFromJson);
    if (obj instanceof Object) {
        if (Array.isArray(obj)) {
            return obj.map(
                    e => {
                        e._class = _class;
                        return objectFromJson(null,e);
                    }
            );
        }
        obj._class = _class;
        return obj;
    }
    return obj;
};
////método para transformar una serie de argumentos a parte del link para las peticiones
//// /servidor/action=accion&arg0="hola"&arg1="mundo"
const empaquetador = (...args) => {
    return args.reduce(
            (resultado, argumento, indice) => {
        return resultado += `&arg${indice}=${toJson(argumento)}`
    }
    , ""/*estado inicial*/
            );
};

const Proxy = (servidor/*nombre del servlet*/,
        accion,
        metodo/*GET,POST,DELETE...*/,
        callBack,
        objetoEsperado,
        ...parametros) => {
    console.log("Action: " + accion);
    let AJAX_req = new XMLHttpRequest();
    let url = `${servidor}?action=${accion}`;
    AJAX_req.open(metodo, url, true);
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function () {
        if (AJAX_req.readyState === 4 && AJAX_req.status === 200) {
            let jsonText = AJAX_req.responseText;
            console.log("Respuesta: " + jsonText);
            let objeto = toObject(jsonText, objetoEsperado);
            callBack(objeto);
        }
    };
    /**envio de los parametros*/
    AJAX_req.send(
            empaquetador(parametros)
            );
};
Proxy.getParadas = function (callBack){
    var AJAX_req = new XMLHttpRequest();
    url = "/SMART/SMART?action=todasLasParadas";
    AJAX_req.open("GET", url, true); 
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if (AJAX_req.readyState === 4 && AJAX_req.status === 200){
            var object = JSON.parse(AJAX_req.responseText, JsonUtils.revive);
            callBack(object);
        }
    };
    AJAX_req.send();
};





