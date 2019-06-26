package ejercicio1.pageFactory;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLogin {

    static private String user = "mngr197881";
    static private String pass = "YsAravU";

    private WebDriver driver;
    private LoginPage pgLogin;
    private ManagerPage manPage;

    @BeforeEach
    public void setup()
    {
        // Crear la instanacia de Chrome, puesto que no tenemos instalado FireFox.
        driver = new Firef oxDriver();

        // Creamos la página de inicio.
        pgLogin = new LoginPage(driver);
    }

    @Test
    public void test_Login_Correct()
    {
        String pageLoginTitle = pgLogin.getLoginTitle();
        Assertions.assertTrue(pageLoginTitle.toLowerCase().contains("guru99 bank"));
        pgLogin.login(user, pass);
        manPage = new ManagerPage(driver);
        String fromManPage = manPage.getHomePageDashboardUserName().toLowerCase();
        Assertions.assertTrue(fromManPage.contains("manager id : " + user));
    }

    @Test
    public void test_Login_Incorrect()
    {
        String pageLoginTitle = pgLogin.getLoginTitle();
        Assertions.assertTrue(pageLoginTitle.toLowerCase().contains("guru99 bank"));
        pgLogin.login(user, "ASDAjk");
        // manPage = new ManagerPage(driver);

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        Assertions.assertTrue(text.toLowerCase().contains("user or password is not valid"));
        driver.close();
    }

    /*@AfterEach
    public void setoff()
    {
        // Cerramos el navegador cada vez que ejecutamos una prueba.
        driver.close();
    }*/
}
