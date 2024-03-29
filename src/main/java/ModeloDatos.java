import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import Modelos.Jugador;

public class ModeloDatos {

    private Connection con;
    private Statement set;
    private ResultSet rs;

    public void abrirConexion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Con variables de entorno
            String dbHost = System.getenv().get("DATABASE_HOST");
            String dbPort = System.getenv().get("DATABASE_PORT");
            String dbName = System.getenv().get("DATABASE_NAME");
            String dbUser = System.getenv().get("DATABASE_USER");
            String dbPass = System.getenv().get("DATABASE_PASS");

            String url = dbHost + ":" + dbPort + "/" + dbName;
            con = DriverManager.getConnection(url, dbUser, dbPass);

        } catch (Exception e) {
            // No se ha conectado
            Logger.getLogger("No se ha podido conectar");
            Logger.getLogger("El error es: " + e.getMessage());
        }
    }

    public boolean existeJugador(String nombre) {
        boolean existe = false;
        String cad;
        try {
            set = con.createStatement();
            rs = set.executeQuery("SELECT * FROM Jugadores");
            while (rs.next()) {
                cad = rs.getString("Nombre");
                cad = cad.trim();
                if (cad.compareTo(nombre.trim()) == 0) {
                    existe = true;
                }
            }
            rs.close();
            set.close();
        } catch (Exception e) {
            // No lee de la tabla
            Logger.getLogger("No lee de la tabla");
            Logger.getLogger("El error es: " + e.getMessage());
        }
        return (existe);
    }

  public void actualizarJugador(String nombre) {
    try {
        set = con.createStatement();
        set.executeUpdate("UPDATE Jugadores SET votos = votos + 1 WHERE nombre LIKE '%" + nombre + "%'");
        rs.close();
        set.close();
    } catch (Exception e) {
        // No modifica la tabla
        Logger.getLogger("No lee de la tabla");
        Logger.getLogger("El error es: " + e.getMessage());
    }
}


    public void insertarJugador(String nombre) {
        try {
            set = con.createStatement();
            set.executeUpdate("INSERT INTO Jugadores " + " (nombre,votos) VALUES ('" + nombre + "',1)");
            rs.close();
            set.close();
        } catch (Exception e) {
            // No inserta en la tabla
            Logger.getLogger("No inserta en la tabla");
            Logger.getLogger("El error es: " + e.getMessage());
        }
    }

    public void restaurarVotos() {
        try {
            set = con.createStatement();
            set.executeUpdate("UPDATE Jugadores SET votos=0");
            rs.close();
            set.close();
        } catch (Exception e) {
            // No modifica la tabla
            Logger.getLogger("No modifica la tabla");
            Logger.getLogger("El error es: " + e.getMessage());
        }
    }

    public List<Jugador> obtenerJugadores(){
        List<Jugador> jugadores = new ArrayList<Jugador>();
        try {
            set = con.createStatement();
            rs = set.executeQuery("SELECT * FROM Jugadores");
            while (rs.next()) {
                Jugador jugador = new Jugador(rs.getInt("id"), rs.getString("nombre"), rs.getInt("votos"));
                jugadores.add(jugador);
            }
            rs.close();
            set.close();
        } catch (Exception e) {
            // No lee de la tabla
            Logger.getLogger("No lee de la tabla");
            Logger.getLogger("El error es: " + e.getMessage());
        }
        return jugadores;
    }
    public int obtenerVotos(String nombre) {
        int votos = 0;
        try {
            set = con.createStatement();
            rs = set.executeQuery("SELECT votos FROM Jugadores WHERE nombre LIKE '%" + nombre + "%'");
            while (rs.next()) {
                votos = rs.getInt("votos");
            }
            rs.close();
            set.close();
        } catch (Exception e) {
            // No lee de la tabla
            Logger.getLogger("No lee de la tabla");
            Logger.getLogger("El error es: " + e.getMessage());
        }
        return votos;
    }

    public void cerrarConexion() {
        try {
            con.close();
        } catch (Exception e) {
            Logger.getLogger("El error es: " + e.getMessage());
        }
    }


}
