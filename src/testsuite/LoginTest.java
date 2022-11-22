package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter id text
        sendTextToElements(By.name("username"), "Admin");
        // Enter password text
        sendTextToElements(By.name("password"), "admin123");
        // click on login tab
        clickOnElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        //Expected Message
        String expectMessage = "Dashboard";

        //Find the text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//header/div[1]/div[1]/span[1]/h6[1]"));
        String actualMessage = actualTextMessageElement.getText();

        // Validate actual and expected message
        Assert.assertEquals("Dashboard text not displayed", expectMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        // Enter id text
        sendTextToElements(By.name("username"), "Admin");
        // Enter password text
        sendTextToElements(By.name("password"), "admin123");
        // click on login tab
        clickOnElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

    }
    @After
    public void tearDown() {

        closeBrowser();
    }
}
