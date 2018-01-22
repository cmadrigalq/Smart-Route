<%-- 
    Document   : newjsp
    Created on : 14/01/2018, 11:55:28 PM
    Author     : Cynthia Madrigal Quesada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/Proxy.js"></script>
        <title>Administración de puntos</title>
    </head>
    <body>
        <%@ include file="mapa.jsp" %>
        <script>
            Punto.marcarTodos();
        </script>
    </body>
</html>
