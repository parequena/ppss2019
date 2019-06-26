package ejercicio1.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage
{
    private WebDriver driver;
    private WebElement loginElement, userID, password,login, loginTitle;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.driver.get("http://demo.guru99.com/V4");

        loginTitle  = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("barone")));
        userID = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("uid")));
        password = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        login = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("btnLogin")));
    }

    public void login(String user, String pass)
    {
        userID.sendKeys(user);
        password.sendKeys(pass);
        login.click();
    }

    public String getLoginTitle()
    {
        return loginTitle.getText();
    }

}