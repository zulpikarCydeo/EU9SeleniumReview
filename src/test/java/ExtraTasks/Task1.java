package ExtraTasks;

import org.openqa.selenium.*;
import org.testng.annotations.*;
import utilities.*;

import java.util.*;
import java.util.concurrent.*;

public class Task1 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void getUrl() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }

    @Test
    public void getLinkNumber() {

        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));

        userName.sendKeys("Tester");
        password.sendKeys("test");
        loginBtn.click();

        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("Link count = " + links.size());

        for (WebElement link : links) {
            System.out.println("link text = " + link.getText());
        }

    }
}
