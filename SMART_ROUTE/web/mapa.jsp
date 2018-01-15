<%-- 
    Document   : mapa
    Created on : Jan 10, 2018, 10:15:33 PM
    Author     : jos_c
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/estilos.css"/>
        <style>
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
            #map {
                height: 100%;
            }
            /* Optional: Makes the sample page fill the window. */
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }
        </style>
        <link rel="shortcut icon" href="imagenes/movieicon.png"/>
        <!-- script jquery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="js/map.js"></script>
        <script src="js/Punto.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="jquery-3.0.0.min.js"></script>
        <script src="css/jquery-1.12.4.min.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script 
            async 
            defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAu-n3UPJPOTDAOMHNDKxqAFE1W0i9tZn4&callback=initMap">
        </script>
        <title>Mapa</title>
    </head>
    <body>
        <div id="map"></div>
    </body>
</html>
