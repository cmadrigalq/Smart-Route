<%-- 
    Document   : mapa
    Created on : Jan 10, 2018, 10:15:33 PM
    Author     : jos_c
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mapa</title>

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
    <body>
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
        
        <div id="map" style="width: 1500px; height: 1000px"></div>

        <script>
            var marker;
            var map;
            function addMarker(location) {
                marker = new google.maps.Marker({
                    position: location,
                    map: map,
                    draggable: true,
                    animation: google.maps.Animation.DROP
                });
            }

            function initMap() {
                map = new google.maps.Map(document.getElementById('map'), {
                    center: new google.maps.LatLng(10, -444),
                    zoom: 9,
                    mapTypeId: google.maps.MapTypeId.HYBRID,
                    mapTypeControl: false,
                    zoomControl: true,
                    zoomControlOptions: {
                        style: google.maps.ZoomControlStyle.SMALL
                    }
                }
                );
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function (position) {
                        var pos = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude
                        };

                        google.maps.event.addListener(map, 'click', function (event) {
                            addMarker(event.latLng);
                            google.maps.event.addListener(marker, 'click', function () {
                                ruta();
                            })
                        });

                        function ruta() {
                            var objConfigDR = {
                                map: map,
                            }
                            var objConfigDS = {
                                origin: pos,
                                destination: marker.position,
                                travelMode: google.maps.TravelMode.DRIVING
                            }

                            var directionsService = new google.maps.DirectionsService();
                            var directionRenderer = new google.maps.DirectionsRenderer(objConfigDR);
                            directionsService.route(objConfigDS, fnRutear);
                            function fnRutear(resultados, status) {
                                if (status == 'OK') {
                                    directionRenderer.setDirections(resultados);
                                } else {
                                    alert('error' + status);
                                }
                            }
                        }


                    }, function () {
                        handleLocationError(true, infoWindow, map.getCenter());
                    });
                } else {
                    handleLocationError(false, infoWindow, map.getCenter());
                }
            }

            function handleLocationError(browserHasGeolocation, infoWindow, pos) {
                infoWindow.setPosition(pos);
                infoWindow.setContent(browserHasGeolocation ?
                        'Error: The Geolocation service failed.' :
                        'Error: Your browser doesn\'t support geolocation.');
            }

            function downloadUrl(url, callback) {
                var request = window.ActiveXObject ?
                        new ActiveXObject('Microsoft.XMLHTTP') :
                        new XMLHttpRequest;

                request.onreadystatechange = function () {
                    if (request.readyState == 4) {
                        request.onreadystatechange = doNothing;
                        callback(request, request.status);
                    }
                };

                request.open('GET', url, true);
                request.send(null);
            }

            function doNothing() {}

        </script>

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAn4rYPSF3MO72qt5FB6s3zD5EC8HV0LcI&amp;callback=initMap"></script>
    </body>
</html>
