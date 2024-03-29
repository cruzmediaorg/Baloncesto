import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebasPhantomjsIT {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/bin/phantomjs");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[]{"--web-security=no", "--ignore-ssl-errors=yes"});
        driver = new PhantomJSDriver(caps);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void tituloIndexTest() {
        driver.navigate().to("http://localhost:8080/Baloncesto/");
        assertEquals("Votacion mejor jugador liga ACB", driver.getTitle(), "El titulo no es correcto");
        System.out.println(driver.getTitle());
    }

    @Test
    public void restaurarVotosTest() {
        // Visitar la página principal
        driver.navigate().to("http://localhost:8080/Baloncesto/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Hacer una votación
        driver.findElement(By.name("txtNombre")).sendKeys("Luis");
        driver.findElement(By.name("txtMail")).sendKeys("l.cruza@uah.edu.es");
        driver.findElement(By.name("R1")).click(); // Seleccionar el primer radio button (Llull)
        driver.findElement(By.name("B1")).click(); // Hacer click en el botón de votar
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Restaurar los votos
        driver.navigate().to("http://localhost:8080/Baloncesto/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("botonRestaurar")).click(); // Hacer click en el botón de restaurar votos

        // Comprobar que los votos se han restaurado en /VerVotos.jsp
        driver.navigate().to("http://localhost:8080/Baloncesto/VerVotos");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement llullVotes = driver.findElement(By.id("Llullvoto"));
        WebElement rudyVotes = driver.findElement(By.id("Rudyvoto"));
        WebElement felipeVotes = driver.findElement(By.id("Tavaresvoto"));

        // Comprobar que los votos se han restaurado
        assertEquals("0", llullVotes.getText());
        assertEquals("0", rudyVotes.getText());
        assertEquals("0", felipeVotes.getText());

        // Cerrar el navegador
        driver.quit();
    }

    @Test
    public void nuevoJugadorTest() {
        // Visitar la página principal
        driver.navigate().to("http://localhost:8080/Baloncesto/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Hacer una votación
        driver.findElement(By.name("txtNombre")).sendKeys("Luis");
        driver.findElement(By.name("txtMail")).sendKeys("l.cruza@uah.edu.es");
        driver.findElement(By.id("otroRadio")).click(); // Seleccionar el ultimo radio button (Otros)
        driver.findElement(By.name("txtOtros")).sendKeys("LukaDoncic");
        driver.findElement(By.name("B1")).click(); // Hacer click en el botón de votar
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Comprobar que los votos se han añadido en /VerVotos.jsp
        driver.navigate().to("http://localhost:8080/Baloncesto/VerVotos");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement lukaNombre = driver.findElement(By.id("LukaDoncic"));
        WebElement lukaVotes = driver.findElement(By.id("LukaDoncicvoto"));


        // Comprobar que los votos se han restaurado
        assertEquals("LukaDoncic", lukaNombre.getText());
        assertEquals("1", lukaVotes.getText());

        // Cerrar el navegador
        driver.quit();
    }


}
