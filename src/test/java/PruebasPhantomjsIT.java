import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PruebasPhantomjsIT
{
private static WebDriver driver=null;
@Test
public void tituloIndexTest()
{
DesiredCapabilities caps = new DesiredCapabilities();
caps.setJavascriptEnabled(true);
caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"/usr/bin/phantomjs");
caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new
String[] {"--web-security=no", "--ignore-ssl-errors=yes"});
driver = new PhantomJSDriver(caps);
driver.navigate().to("http://localhost:8080/Baloncesto/");
assertEquals("Votacion mejor jugador liga ACB", driver.getTitle(),
"El titulo no es correcto");
 System.out.println(driver.getTitle());
driver.close();
driver.quit();
}
@Test
public void restaurarVotosTest()
{
    // Visitar la página principal
    // Hacer una votación
    // Restaurar los votos
    // Comprobar que los votos se han restaurado en /VerVotos.jsp
    // Cerrar el navegador

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setJavascriptEnabled(true);
    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"/usr/bin/phantomjs");
    caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new
    String[] {"--web-security=no", "--ignore-ssl-errors=yes"});
    driver = new PhantomJSDriver(caps);
    driver.navigate().to("http://localhost:8080/Baloncesto/");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.name("txtNombre")).sendKeys("
    Luis");
    driver.findElement(By.name("txtMail")).sendKeys("
    l.cruza@uah.edu.es"); // Introducir nombre y mail
    driver.findElement(By.name("R1")).click(); // Seleccionar el primer radio button (Llull)
    driver.findElement(By.name("B1")).click(); // Hacer click en el botón de votar
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.navigate().to("http://localhost:8080/Baloncesto/Ver"); // Visitar la página de votos
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    // Expected output:
    // Llull 0
    // Rudy 0
    // Felipe 0

    
 

}