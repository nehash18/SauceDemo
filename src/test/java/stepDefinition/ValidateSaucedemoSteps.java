package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tasks.LaunchBrowser;

import static tasks.TestData.getUserCredentials;

public class ValidateSaucedemoSteps {

    WebDriver driver;
    LaunchBrowser launchBrowser = new LaunchBrowser();
    @Given("customer navigates to SauceDemo URL")
    public void customer_navigates_to_sauce_demo_url() {
        getUserCredentials();
        System.setProperty("webdriver.chrome.driver", "f:\\chromedriver.exe");
        driver = new ChromeDriver();
        launchBrowser.setDriver(driver);
    }

    @When("customer submit username and password")
    public void customer_submit_username_and_password() {
        launchBrowser.login(driver);
    }

    @Then("customer should be logged in")
    public void customer_should_be_logged_in() {
        launchBrowser.validateHomePage(driver);
    }

    @When("customer click on basket icon")
    public void customer_click_on_basket_icon() {
        launchBrowser.clickOnBasketIcon(driver);
    }

    @Then("customer verifies basket is empty")
    public void customer_verifies_basket_is_empty() {
        launchBrowser.validateBasket(driver);
    }



}
