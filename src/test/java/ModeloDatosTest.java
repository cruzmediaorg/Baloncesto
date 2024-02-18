import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ModeloDatosTest {

 @Test
 public void testExisteJugador() {
 System.out.println("Prueba de existeJugador");
 String nombre = "";
 ModeloDatos instance = new ModeloDatos();
 instance.abrirConexion();
 boolean expResult = false;
 boolean result = instance.existeJugador(nombre);
 assertEquals(expResult, result);
    instance.cerrarConexion();
 }

    @Test
    public void testActualizarJugador() {
        System.out.println("Prueba de actualizarJugador");
           ModeloDatos instance = new ModeloDatos();
           String nombre = "Llull";
           instance.abrirConexion();
           Integer expResult = 1;
           instance.actualizarJugador(nombre);
              Integer result = instance.obtenerVotos(nombre);
                assertEquals(expResult, result);
                instance.cerrarConexion();

    }
}