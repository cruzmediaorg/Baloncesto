<html>
    <head><title>Votaci&oacute;n mejor jugador liga ACB</title>
    <style>
        body {
            background-color: cyan;
            color: white;
            font-family: Arial, sans-serif;
        }
    </style>
    </head>
    <body>
       <h1>Votos de los jugadores</h1>
       <div id="votos">
           <table>
               <thead>
                   <tr>
                       <th>Jugador</th>
                       <th>Votos</th>
                   </tr>
                   </thead>
                   <tbody>
                    <%@ page import="java.util.*" %>
                    <% for (int i = 0; i < ((List<String>) session.getAttribute("nombres")).size(); i++) { %>
                    <tr>
                        <td><%= ((List<String>) session.getAttribute("nombres")).get(i) %></td>
                        <td id="<%= ((List<String>) session.getAttribute("nombres")).get(i) %>voto"><%= ((List<Integer>) session.getAttribute("votos")).get(i) %></td>
                    </tr>
                    <% } %>
                    </tbody>
           </table>
         </div>
            <br> <a href="index.html"> Ir al comienzo</a>   
    </body>
</html>
