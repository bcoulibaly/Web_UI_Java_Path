package de.qcentris.seleniumTest;

import de.qcentris.Pages.TestingHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    protected String HOMEPAGELINK = "https://the-internet.herokuapp.com/";
    protected TestingHomePage testingHomePage;
    protected WebDriverWait webDriverWait;
    private WebDriver chromeDriver;

    @BeforeAll
    static void initAll () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void init () {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//        this.chromeDriver = new ChromeDriver();
        this.chromeDriver = WebDriverManager.chromedriver().create();
        this.chromeDriver.get(this.HOMEPAGELINK);
        this.testingHomePage = new TestingHomePage(this.chromeDriver);
    }


    @AfterEach
    void tearDown () {
        this.chromeDriver.quit();
    }
}
