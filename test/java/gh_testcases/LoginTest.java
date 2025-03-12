package gh_testcases;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import gh_baseclass.BaseClass;
import gh_pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginTest {
    public static final Logger logger = Logger.getLogger(LoginTest.class);
    public BaseClass base;
    public LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        logger.info("Initializing test setup...");
        base = new BaseClass();
        base.setUp();
        loginPage = new LoginPage(base.getDriver());
        logger.info("Test setup completed.");
    }

    @Test(priority = 1)
    public void testSingleUserLogin() throws InterruptedException {
        logger.info("Executing Single User Login Test");
        String username = base.config.getProperty("username");
        String password = base.config.getProperty("password");
        loginPage.login(username, password);
        Thread.sleep(2000);
        logger.info("Single User Login Test Completed");
    }

    @Test(priority = 2, dataProvider = "multiUserData")
    public void testMultiUserLogin(String username, String password) throws InterruptedException {
        logger.info("Executing Multi-User Login Test for username: " + username);
        loginPage.login(username, password);
        Thread.sleep(3000);
        logger.info("Multi-User Login Test Completed for username: " + username);
    }

    @DataProvider(name = "multiUserData")
    public Object[][] getMultiUserData() throws IOException {
        logger.info("Reading user data from Excel file...");
        String filePath = "D:\\Excel files\\UserData.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("LoginData");

        int rowCount = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rowCount - 1][2];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            data[i - 1][0] = row.getCell(0).getStringCellValue();
            data[i - 1][1] = row.getCell(1).getStringCellValue();
            logger.info("Loaded user: " + data[i - 1][0]);
        }

        workbook.close();
        file.close();
        logger.info("Excel data loading completed.");
        return data;
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Closing the browser and ending the test.");
        base.tearDown();
    }
}
