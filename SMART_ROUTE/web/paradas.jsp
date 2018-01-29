<%@page import="Servicios.ServicioRuta"%>
<%@page import="Servicios.ServicioBus"%>
<%@page import="Servicios.ServicioEmpresa"%>
<%@page import="Utilitarios.DateUtil"%>
<%@page import="entidades.Horario"%>
<%@page import="java.util.List"%>
<%@page import="Servicios.ServicioHorario"%>
<%@page import="Servicios.ServicioHorario"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SmartRoute</title>

        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/Table.css"/>
        <link rel="stylesheet" type="text/css" href="css/estilos.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="shortcut icon" href="imagenes/movieicon.png"/>
        <!-- script Angular JS -->

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

        <!-- script jquery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="jquery-3.0.0.min.js"></script>
        <script src="css/jquery-1.12.4.min.js" type="text/javascript"></script>
        <script src="js/Horario.js" type="text/javascript"></script>
        <script src="js/genTable.js" type="text/javascript"></script>
        <script src="js/Proxy.js" type="text/javascript"></script>
        <script src="js/Utilitario.js" type="text/javascript"></script>
        <script src="js/horarios_eventos.js" type="text/javascript"></script>
    </head>

    <body class="fondo" ng-app="myApp" ng-controller="paradasCtrl">

        <!-- menu Encabezado -->       
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
        <div class="col-md-8 col-md-offset-2">
            <div class="form-group" >
                <h4 class="titulo3" >Rutas</h4>
                <input placeHolder="Filtro" id="filtroRutas" class="selectpicker form-control " />
                <select data-live-search="true" class="selectpicker form-control  btn-success"  
                        id="rutasOpciones" >
                    <option id ="rutasOpciones0" value="0">Elija la ruta deseada</option>
                    <%
                        try {
                            ServicioRuta sr = new ServicioRuta();
                            out.println(sr.getListadoRutas1());
                            out.println(sr.getListadoRutas2());
                            sr = null;
                        } catch (Exception ex) {
                            out.println(
                                    "<option>" + ex.toString() + "</option>"
                            );
                        }
                    %>
                </select>
            </div>
        </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2" >
            <div class="form-group" >
                <input type="button" class="btn btn-danger" id="buscar" value="BUSCAR" ng-click="search()">
            </div>
        </div>
    </div>
    <div class="col-md-8 col-md-offset-2">
        <div class="form-group" >
            <div > 
                <table class="table">
                    <tr ng-repeat="x in paradas">
                        <td>{{ x }}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

    <script>
        var app = angular.module('myApp', []);
        app.controller('paradasCtrl', $scope => {
            $scope.search = () => {
                let id = document.getElementById('rutasOpciones');
                let ruta = id.value;
                let valores = ruta.split("-");
                if (ruta != 0)
                {
                    let p = new Promise(t => {
                        Proxy("SMART", "buscarPorRutaParadas", "POST",
                                res => {
                                    if (res === null || res === undefined || !Array.isArray(res))
                                        alert(res);
                                    else {
                                        t(res);
                                    }
                                }, valores[0], valores[1]);
                    });
                    p.then(res => {
                        console.log(res);
                        $scope.paradas = res;
                        $scope.$apply();
                        console.log($scope.paradas);
                    });
                }
            };

            //$scope.paradas = [{id: 1}, {id: 3}];
        });
    </script>
</body>
</html>