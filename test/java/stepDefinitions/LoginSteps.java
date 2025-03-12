package stepDefinitions;

import gh_pages.LoginPage;
import gh_config_properties.ConfigReader;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps() throws InterruptedException {
        this.loginPage = new LoginPage(CommonSteps.getDriver());
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        loginPage.login(username, password);
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue("Login failed!", loginPage.isLoginSuccessful());
    }
}
