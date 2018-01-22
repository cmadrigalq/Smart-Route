var markerOrigen;
var markerDestino;
var marker;
var map;
var directionsService;
var directionRenderer;
var objConfigDR;
var objConfigDS;



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
            });
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

function calcularRuta() {
    if (!markerOrigen || !markerDestino) {
        alert('Seleccionar el origen y destino');
        return;
    }
    objConfigDR = {
        map: map,
    }
    objConfigDS = {
        origin: markerOrigen.position,
        destination: markerDestino.position,
        travelMode: google.maps.TravelMode.DRIVING
    }
    
    if (directionsService) directionRenderer.setMap(null);
    directionsService = new google.maps.DirectionsService();
    directionRenderer = new google.maps.DirectionsRenderer(objConfigDR);
    directionsService.route(objConfigDS, fnRutear);
    function fnRutear(resultados, status) {
        if (status == 'OK') {
            directionRenderer.setDirections(resultados);
        } else {
            alert('error' + status);
        }
    }
}

function changeOrigen(lat, long) {
    if (markerOrigen) markerOrigen.setMap(null);
    markerOrigen = new google.maps.Marker({
        position: {
            lat: lat,
            lng: long
        },
        map: map,
        draggable: true,
        animation: google.maps.Animation.DROP
    });
}

function changeDestino(lat, long) {
    if (markerDestino) markerDestino.setMap(null);
    markerDestino = new google.maps.Marker({
        position: {
            lat: lat,
            lng: long
        },
        map: map,
        draggable: true,
        animation: google.maps.Animation.DROP
    });
}