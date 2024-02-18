import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ModeloDatosTest {

 @Test
 public void testExisteJugador() {
 System.out.println("Prueba de existeJugador");
 String nombre = "";
 ModeloDatos instance = new ModeloDatos();
 boolean expResult = false;
 boolean result = instance.existeJugador(nombre);
 assertEquals(expResult, result);
//  fail("Fallo forzado.");
 }


    @Test
    public void testActualizarJugador() {
            System.out.println("Prueba de actualizarJugador");
            String nombre = "Llull";
            ModeloDatos instance = new ModeloDatos();
            instance.actualizarJugador(nombre);
            int votos = instance.obtenerVotos(nombre);
            assertEquals(1, votos);
    }
}