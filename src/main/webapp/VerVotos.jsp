<%@ page import="java.util.List" %>
<html>
<head>
    <title>Votación mejor jugador liga ACB</title>
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
                    <th id="jugador"
                    >Jugador</th>
                    <th id="votos"
                    >Votos</th>
                </tr>
            </thead>
            <tbody>
                <% List<String> nombres = (List<String>) session.getAttribute("nombres");
                   List<Integer> votos = (List<Integer>) session.getAttribute("votos");
                   if(nombres != null && votos != null) {
                       for (int i = 0; i < nombres.size(); i++) { %>
                           <tr>
                               <td id="<%= nombres.get(i) %>"
                               ><%= nombres.get(i) %></td>
                               <td id="<%= nombres.get(i) %>voto"><%= votos.get(i) %></td>
                           </tr>
                <%     }
                   } %>
            </tbody>
        </table>
    </div>
    <br> <a href="index.html">Ir al comienzo</a>   
</body>
</html>
