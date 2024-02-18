<!DOCTYPE html>
<html lang="es">
    <head><title>Votaci&oacute;n mejor jugador liga ACB</title>
    <style>
        body {
            background-color: red;
            color: yellow;
            font-family: Arial, sans-serif;
        }
    </style>
    </head>
    <body>
        Votaci&oacute;n al mejor jugador de la liga ACB
        <hr>
        <%
            String nombreP = (String) session.getAttribute("nombreCliente");
        %>
        <br>Muchas gracias <%=nombreP%> por su voto
        </font>
        <br>
        <br> <a href="index.html"> Ir al comienzo</a>
    </body>
</html>
