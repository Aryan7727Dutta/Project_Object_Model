package gh_baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseClass {
    public static WebDriver driver;
    public static Properties config;
    public static Logger logger;
    public static RequestSpecification request;


    static {
        try {
            // Initialize Logger
            logger = Logger.getLogger(BaseClass.class);
            PropertyConfigurator.configure("C:/Usersdutta/Pom_Design_Model/src/test/resources/log4j.properties");

            // Load config.properties
            FileInputStream file = new FileInputStream("src/main/java/gh_config_properties/config.properties");
            config = new Properties();
            config.load(file);
            file.close();

            // Initialize RestAssured Base URI
            RestAssured.baseURI = "https://api.github.com";
            request = RestAssured.given()
                    .header("Authorization", "Bearer YOUR_ACCESS_TOKEN")
                    .header("Content-Type", "application/json");

            logger.info("Configuration and RestAssured setup completed.");

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Failed to load config.properties file.", e);
        }
    }

    public static void setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(config.getProperty("url"));
            logger.info("WebDriver initialized and navigated to: " + config.getProperty("url"));
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("WebDriver closed.");
        }
    }
}
