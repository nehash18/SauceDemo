package tasks;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.sql.Driver;
import java.util.List;

import static configuration.ConfigurationContext.BASE_URL;
import static pages.HomePage.*;
import static tasks.TestData.getUserCredentials;


public class LaunchBrowser {

    public void setDriver(WebDriver driver) {

        driver.get(BASE_URL);
        driver.manage().window().maximize();
        System.out.println("DRIVER.GET TITTLE" + driver.getTitle());

    }

    public void login(WebDriver driver) {

        driver.findElement(By.xpath(LoginPage.userName)).sendKeys(getUserCredentials().keySet().toArray()[0].toString());
        driver.findElement(By.xpath(LoginPage.password)).sendKeys(getUserCredentials().values().toArray()[0].toString());
        driver.findElement(By.xpath(LoginPage.loginButton)).click();

    }

    public void validateHomePage(WebDriver driver) {
        Assert.assertTrue(driver.findElement(By.className(shoppingCart)).isDisplayed());
    }

    public void clickOnBasketIcon(WebDriver driver){
        driver.findElement(By.className(shoppingCart)).click();
    }

    public void validateBasket(WebDriver driver){
        WebElement cartElement1 = driver.findElement(By.className(cartList));
        List<WebElement> elementList = cartElement1.findElements(By.xpath("./child::*"));
        boolean isItemPresent = false;
        for ( WebElement i : elementList ) {
            if(i.getAttribute("class").equalsIgnoreCase(cartItem)){
                isItemPresent = true;
            }
        }
        Assert.assertEquals(isItemPresent,false);

        driver.close();
    }


}
