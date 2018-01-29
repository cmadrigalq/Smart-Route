<%-- 
    Document   : index
    Created on : 28/12/2017, 09:34:44 PM
    Author     : Melissa
--%>


<%@page import="entidades.Punto"%>
<%@page import="java.util.List"%>
<%@page import="Servicios.ServicioPuntos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SmartRoute</title>

        <!-- CSS -->

        <link rel="stylesheet" type="text/css" href="css/estilos.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="shortcut icon" href="imagenes/movieicon.png"/>
        <!-- script jquery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="jquery-3.0.0.min.js"></script>
        <script src="css/jquery-1.12.4.min.js" type="text/javascript"></script>
        <script src="js/Mapa.js" type="text/javascript"></script>
        <script src="js/Proxy.js" type="text/javascript"></script>
        <script src="js/Punto.js" type="text/javascript"></script>
        <script src="js/Utilitario.js" type="text/javascript"></script>
        <script src="js/index_eventos.js" type="text/javascript"></script>
    </head>

    <body class="fondo">

        <!-- menu Encabezado -->       
             <!-- menu Encabezado -->            
    <nav class="navbar navbar-inverse">
    <div class="container-fluid">
         <!-- logo--> 
     <a class="navbar-brand page-scroll" href="index.jsp">
     <img src="imagenes/logo2.png"/>
     </a>  
          <!-- ICONO DE MENU DESPLEGABLE--> 
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      
    </div>
    <%@include file="barra.jsp" %>
  </div>
</nav>

        <!-- top de la pagina-->  
        <header class="intro">
            <div class="container">
                <div class="col-md-8 col-md-offset-2">
                    <img src="imagenes/logo1.png"/>
                    <HR width=100% align="center">
                    <h1 class="titulo" >Aplicación de rutas inteligentes</h1>
                </div>
            </div>
        </header> 

        <!-- DropDawnList de ruta origen/destino-->  
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="form-group" >
                    <h4 class="titulo3" >ORIGEN</h4>
                    <input placeHolder="Filtro" id="filtroOrigen" class="selectpicker form-control " />
                    <select data-live-search="true" class="selectpicker form-control  btn-success"  
                            id="origenBus" >
                        <option id ="origen" value="0">Elija un Origen</option>
                        <%
                            try {
                                ServicioPuntos sp = new ServicioPuntos();
                                String opciones = sp.listadoDeDescripciones();
                                out.print(opciones);
                                sp = null;
                            } catch (Exception ex) {
                                out.println(
                                  "<option>"+ex.toString()+"</option>"
                                );
                            }
                        %>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="form-group" >
                    <h4 class="titulo3" >DESTINO</h4>
                    <input placeHolder="Filtro" id="filtroDestino" class="selectpicker form-control " />
                    <select data-live-search="true" 
                            class="selectpicker form-control btn-info" 
                            id="destinoBus">
                        <option id ="destino" value="0">Elija un Destino</option>
                        <%
                            try {
                                ServicioPuntos sp2 = new ServicioPuntos();
                                String opciones2 = sp2.listadoDeDescripciones();
                                out.print(opciones2);
                                sp2 = null;
                            } catch (Exception ex) {
                                out.println(
                                  "<option>"+ex.toString()+"</option>"
                                );
                            }
                        %>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="form-group" >
                    <input type="button" class="btn btn-danger" id="calRuta" value="Calcular Ruta" onclick="calcularRuta()">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="form-group" >
                    <div id="map" style="width: 100%; height: 300px;"></div>
                </div>
            </div>
        </div>

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDIhBttn3yBK9T_SBflk1RRuoNbD_Q-QWM&amp;callback=initMap"></script>

            <!--<script>
                function mostrarRutas() {
                var origen = document.getElementById("origen");
                var destino = document.getElementById("destino");
                var opcion = document.createElement("option");
                origen.add(opcion);
                opcion = document.createElement("option");
                destino.add(opcion);
                for (var i = 0; i < paradas.length; i++) {
                    opcion = document.createElement("option");
                    opcion.value = paradas.id;
                    opcion.textContent = paradas.id;
                    origen.add(opcion);
                    opcion = document.createElement("option");
                    opcion.value = paradas.id;
                    opcion.textContent = paradas.id;
                    destino.add(opcion);
                }
            }
                Proxy("SMART",
                      "todasLasParadas",
                      "GET",
                      (res)=>{
                          if(res === null || res === undefined
                                  || !Array.isArray(res)){
                              alert("Fail!");
                                  }
                                  else{
                                    res.forEach(e=>addPunto(e));
                                  }
                      },
                      "Parada");
                /*
                var paradas;
                function pageLoad(event) {
                    Proxy.getParadas(function (resultado) {
                        paradas = resultado;
                        mostrarRutas();
                    });
                }
                */



               // document.addEventListener("DOMContentLoaded", pageLoad);

            </script> -->
    </body>
</html>