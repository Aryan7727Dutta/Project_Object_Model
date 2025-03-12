package stepDefinitions;

import gh_baseclass.BaseClass;
import gh_utility.CommonUtils;
import io.cucumber.java.en.Given;

public class CommonSteps extends BaseClass {
    protected CommonUtils commonUtils;

    public CommonSteps() {
        commonUtils = new CommonUtils(getDriver());
    }

    @Given("User is on the GitHub login page")
    public void user_is_on_github_login_page() {
        setUp();
    }
}
