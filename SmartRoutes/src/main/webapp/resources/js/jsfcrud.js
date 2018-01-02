var jsfcrud = {};
jsfcrud.busyImagePath = '/SmartRoutes/faces/busy.gif';
jsfcrud.isDynamicFacesAvailable = typeof DynaFaces != 'undefined';
jsfcrud.canAjaxEnableForm = true;
if (!jsfcrud.isDynamicFacesAvailable) {
    jsfcrud.canAjaxEnableForm = false;
}
if (jsfcrud.isDynamicFacesAvailable) {
    Form.Element.Serializers.selectOne = function (element) {
        var value = '', opt, index = element.selectedIndex;
        if (index >= 0) {
            opt = element.options[index];
            value = opt.value;
        }
        return [element.name, value];
    };
}
jsfcrud.postReplace = function (element, markup) {
    markup.evalScripts();
    setTimeout(function () {
        jsfcrud.ajaxEnableForm({options: {postReplace: jsfcrud.postReplace}});
    }, 20);
}
jsfcrud.ajaxEnableForm = function (args) {
    if (!jsfcrud.canAjaxEnableForm) {
        return;
    }

    if (typeof args == undefined || args == null) {
        args = {};
    }

    if (typeof args.options == 'undefined') {
        args.options = {};
    }

    var sourceElement = null;
    if (typeof args.sourceElementId != 'undefined' && args.sourceElementId != null) {
        sourceElement = document.getElementById(args.sourceElementId);
    }

    if (typeof args.formId == 'undefined' || args.formId == null) {
        args.formId = 0;
    }

    //insert busy image we'll display when sending an Ajax request
    jsfcrud.insertBusyImage();

    document.forms[args.formId].submit = function () {
        var busyImage = document.getElementById('busyImage');
        if (busyImage) {
            busyImage.style.display = 'block';
        }
        DynaFaces.fireAjaxTransaction(sourceElement, args.options);
    };
};

jsfcrud.insertBusyImage = function () {
    var busyImage = document.createElement('img');
    busyImage.id = 'busyImage';
    busyImage.src = jsfcrud.busyImagePath;
    busyImage.style.display = 'none';
    document.body.insertBefore(busyImage, document.forms[0]);
}

setTimeout(function () {
    jsfcrud.ajaxEnableForm({options: {postReplace: jsfcrud.postReplace}});
}, 20);

function initMap() {
    var map = new google.maps.Map(document.getElementById('map'), {
        center: new google.maps.LatLng(10, -444),
        zoom: 8,
        mapTypeId: google.maps.MapTypeId.HYBRID
    });

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            var marker;

            function addMarker(location, map) {
                marker = new google.maps.Marker({
                    position: location,
                    map: map,
                    draggable: true,
                    animation: google.maps.Animation.DROP
                });
            }

            google.maps.event.addListener(map, 'click', function (event) {
                addMarker(event.latLng, map);
            });

            google.maps.event.addListener(marker, 'click', function (event) {
                ruta(event.latLng);
            });

            function ruta(location) {
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