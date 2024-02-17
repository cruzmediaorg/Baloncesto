
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Restaurar extends HttpServlet {

    private ModeloDatos bd;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        bd = new ModeloDatos();
        bd.abrirConexion();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession s = req.getSession(true);
        bd.restaurarVotos();
        // Llamada a la página jsp que nos da las gracias
        res.sendRedirect(res.encodeRedirectURL("TablaVotos.jsp"));
    }

    public void destroy() {
        bd.cerrarConexion();
        super.destroy();
    }
}
