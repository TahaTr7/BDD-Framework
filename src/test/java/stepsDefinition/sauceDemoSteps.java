package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class sauceDemoSteps {
    WebDriver driver;

    /**
     * This method is used for launching the Chrome browser.
     */
    @Given("User launched the browser")
    public void user_launched_the_browser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    /**
     * This method is used for redirecting to the link.
     * @param url storing link of sauce demo page
     */
    @When("User navigates to {string}")
    public void user_navigates_to(String url) {
        driver.get(url);
    }

    /**
     * This method is for entering credentials and clicking on login button.
     */
    @And("Enter valid credentials and click on login button")
    public void enter_valid_credentials_and_click_on_login_button() {
        driver.findElement(By.xpath("//input[@name='user-name']"))
                .sendKeys("standard_user");

        driver.findElement(By.xpath("//input[contains(@name,'password')]"))
                .sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@name='login-button']")).click();
    }

    /**
     * This method is used to verify the home page after successful login.
     */
    @Then("User should login")
    public void user_should_login() {
        boolean status = driver.findElement(By.xpath("//span[@class='title']"))
                .isDisplayed();

        Assert.assertTrue(status);
    }

    /**
     * This method is used for closing the browser.
     */
    @And("User close the browser")
    public void user_close_the_browser() {
        driver.quit();
    }

    /**
     * This method is for entering invalid credentials and clicking on login button.
     */
    @And("Enter invalid credentials and click on login button")
    public void enterInvalidCredentialsAndClickOnLoginButton() {
        driver.findElement(By.xpath("//input[@name='user-name']"))
                .sendKeys("test_user");

        driver.findElement(By.xpath("//input[contains(@name,'password')]"))
                .sendKeys("test_sauce");

        driver.findElement(By.xpath("//input[@name='login-button']")).click();
    }

    /**
     * This method is for verify the validation message,
     * when user enter wrong credentials.
     */
    @Then("User should get validation message")
    public void userShouldGetValidationMessage() {
        String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";

        String actualErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']" +
                "[contains(.,'Epic sadface: Username and password do not match any user in this service')]"))
                .getText();

        Assert.assertEquals(expectedErrorMsg,actualErrorMsg);
    }

    /**
     * This method is used for adding the product the cart.
     */
    @When("User click on add to cart button")
    public void userClickOnAddToCartButton() {
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']"))
                .click();
    }

    /**
     * This method is used to navigate to Your cart page.
     */
    @And("User navigates to Your Cart page")
    public void userNavigatesToYourCartPage() {
        driver.findElement(By.xpath("//a[contains(@class,'shopping_cart_link')]"))
                .click();
    }

    /**
     * This method is used for verifying the product is added to card.
     */
    @Then("Product should be added to cart")
    public void productShouldBeAddedToCart() {
        boolean status = driver.findElement(By.xpath("//div[@class='inventory_item_name']"))
                .isDisplayed();

        Assert.assertTrue(status);
    }

    /**
     * This method is used from removing the product from cart.
     */
    @And("User remove the product from cart")
    public void userRemoveTheProductFromCart() {
        driver.findElement(By.xpath("//button[@name='remove-sauce-labs-backpack']"))
                .click();
    }

    /**
     * This method is used to click on checkout button.
     */
    @And("User Click on checkout button")
    public void userClickOnCheckoutButton() {
        driver.findElement(By.xpath("//button[@name='checkout']")).click();
    }

    /**
     * This method is used to provide checkout information and continue the process.
     */
    @And("User provided the checkout information")
    public void userProvidedTheCheckoutInformation() {
        driver.findElement(By.id("first-name")).sendKeys("Taha");
        driver.findElement(By.id("last-name")).sendKeys("Rabbani");
        driver.findElement(By.id("postal-code")).sendKeys("75300");
        driver.findElement(By.id("continue")).click();

    }

    /**
     * This method is used for clicking on the finish button.
     */
    @And("User click on Finish")
    public void userClickOnFinish() {
        driver.findElement(By.id("finish")).click();
    }

    /**
     * This method is used to verify the confirmation message.
     */
    @Then("User should receive order confirmation message")
    public void userShouldReceiveOrderConfirmationMessage() {
        String expectedMsg = "Thank you for your order!";
        String actualMsg = driver.findElement(By
                .xpath("//h2[contains(.,'Thank you for your order!')]")).getText();

        Assert.assertEquals(expectedMsg,actualMsg);
    }

    /**
     * This method is used for logout from SwagLab.
     */
    @Then("User click top left nav bar and click on logout")
    public void userClickTopLeftNavBarAndClickOnLogout() {
        driver.findElement(By.xpath("//button[contains(.,'Open Menu')]")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    /**
     * This method is used to verify user is logout and back in login page.
     */
    @And("User should return to login page")
    public void userShouldReturnToLoginPage() {
        boolean loginBtn = driver.findElement(By.
                xpath("//input[@name='login-button']")).isDisplayed();
        Assert.assertTrue(loginBtn);
    }
}
