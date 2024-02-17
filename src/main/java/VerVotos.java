import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import Modelos.Jugador;

public class VerVotos extends HttpServlet {

    private ModeloDatos bd;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        bd = new ModeloDatos();
        bd.abrirConexion();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession s = req.getSession(true);
        List<String> nombres = new ArrayList<>();
        List<Integer> votos = new ArrayList<>();
        List<Jugador> jugadores = bd.obtenerJugadores();
        for (Jugador j : jugadores) {
            nombres.add(j.getNombre());
            votos.add(j.getVotos());
        }
        s.setAttribute("nombres", nombres);
        s.setAttribute("votos", votos);
        res.sendRedirect(res.encodeRedirectURL("VerVotos.jsp"));

    }

    @Override
    public void destroy() {
        bd.cerrarConexion();
        super.destroy();
    }
}