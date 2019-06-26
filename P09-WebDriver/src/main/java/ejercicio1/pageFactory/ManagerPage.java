package ejercicio1.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerPage {
    WebDriver driver;
    WebElement homePageUserName, newCustomer, logOut;

    public ManagerPage(WebDriver driver)
    {
        this.driver = driver;
        homePageUserName = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[3]/td")));

        // homePageUserName = this.driver.findElement(By.xpath("//table//tf[@class='heading3']")); // Joimer uses: "//tr[3]/td"
        newCustomer = this.driver.findElement(By.linkText("New Customer"));
        logOut = driver.findElement(By.linkText("Log out"));
    }

    public String getHomePageDashboardUserName()
    {
        return homePageUserName.getText();
    }
}
