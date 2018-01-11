<%@page import="entidades.Horario"%>
<%@page import="java.util.List"%>
<%@page import="Servicios.ServicioHorario"%>
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
    </head>

    <body class="fondo">

        <!-- menu Encabezado -->       
        <nav class="navbar navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button"  class="navbar-toggle " data-toggle="collapse" data-target=".navbar-main-collapse">                   
                    </button>
                    <a class="navbar-brand page-scroll" href="index.jsp">
                        <img src="imagenes/logo2.png"/>
                    </a>
                </div>

                <!-- lista de links-->
                <div class="collapse navbar-collapse navbar-right navbar-main-collapse a" >
                    <ul  class="nav navbar-nav" >
                        <!-- -->
                        <li class="hidden">
                            <a href=""></a>
                        </li>
                        <li>
                            <a href="index.jsp">Rutas</a>
                        </li>
                        <li>
                            <a  href="horarios.jsp">Horarios</a>
                        </li>
                        <li>
                            <a  href="tarifas.jsp">Tarifas</a>
                        </li>
                        <li>
                            <a  href="mapa.jsp">Mapa</a>
                        </li>
                    </ul>
                </div>
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

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="form-group" >
                    <table border="1" style=" width: 100%">
                        <thead>
                            <tr>
                                <th>ID Horario</th>
                                <th>Llegada</th>
                                <th>Salida</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                /*EJEMPLO!!!!!!! (COMENTAR!)**/
                                ServicioHorario servicio = new ServicioHorario();
                                try {
                                    List<Horario> horarios = servicio.findAll();
                                    for (Horario h : horarios) {
                                        out.println(
                                                String.format("<tr><td>%d</td> <td>%s</td> <td>%s</td><tr>",
                                                        h.getIdHorario(), h.getHoraLlegad(), h.getHoraSalida()
                                                )
                                        );
                                    }
                                } catch (Exception ex) {
                                    out.print("<td>" + ex.toString() + "</td>");
                                }
                                /*FINAL DE EJEMPLO!*/%>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </body>
</html>