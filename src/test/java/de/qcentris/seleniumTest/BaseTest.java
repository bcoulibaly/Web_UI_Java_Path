package de.qcentris.seleniumTest;

import de.qcentris.Pages.TestingHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    protected String HOMEPAGELINK = "https://the-internet.herokuapp.com/";
    private WebDriver chromeDriver;
    protected TestingHomePage testingHomePage;
    protected WebDriverWait webDriverWait;

    @BeforeAll
    static void initAll(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void init () {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//        this.chromeDriver = new ChromeDriver();
        this.chromeDriver = WebDriverManager.chromedriver().create();
        this.chromeDriver.get(HOMEPAGELINK);
        testingHomePage = new TestingHomePage(chromeDriver);
    }

    protected WebElement getWebElement (By elementToFind) {
        return this.chromeDriver.findElement(elementToFind);
    }
    protected List<WebElement> getWebElements (By elementToFind) {
        return this.chromeDriver.findElements(elementToFind);
    }

    @AfterEach
    void tearDown () {
        this.chromeDriver.quit();
    }
}
