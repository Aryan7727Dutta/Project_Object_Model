package gh_testcases;

import org.testng.annotations.*;
import gh_baseclass.BaseClass;
import gh_pages.LoginPage;
import gh_pages.NavigationPage;

public class NavigationTest {
    private BaseClass base;
    private LoginPage loginPage;
    private NavigationPage navigationPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        base = new BaseClass();
        base.setUp();
        loginPage = new LoginPage(base.getDriver());
        navigationPage = new NavigationPage(base.getDriver());

        String username = base.config.getProperty("username");
        String password = base.config.getProperty("password");
        loginPage.login(username, password);
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void testNavigateToHome() throws InterruptedException {
        navigationPage.goToHome();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void testNavigateToRepositories() throws InterruptedException {
        navigationPage.goToRepositories();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void testNavigateTogoToNotifications() throws InterruptedException {
        navigationPage.goToNotifications();
        Thread.sleep(2000);
    }


    @AfterClass
    public void tearDown() {
        base.tearDown();
    }
}
