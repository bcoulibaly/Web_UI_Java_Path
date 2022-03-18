package de.qcentris.seleniumTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class DuckDuckGoTest {
    private WebDriver chromWebDriver;
    private WebDriverWait webDriverWait;
    private static Logger logger = LoggerFactory.getLogger(DuckDuckGoTest.class);

    @BeforeEach
    void setUp () {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        chromWebDriver = new ChromeDriver();
        this.webDriverWait = new WebDriverWait(chromWebDriver, 30);
    }

    @Test
    void getTheMenüList () throws Exception {
        //Arrange
        List<String> expectedElemen = List.of("Home", "About", "Contact Us", "Portfolio", "Gallery");
        //Load page
        chromWebDriver.get("https://the-internet.herokuapp.com/");
        // Act
        chromWebDriver.findElement(By.linkText("Shifting Content")).click();
        chromWebDriver.findElement(By.xpath("//div[contains(@class, 'example')]/a[1]")).click();
        List<String> actual = chromWebDriver.findElements(By.xpath("//div[contains(@class, 'example')]/ul/li")).stream()
                                            .map(WebElement::getText).collect(Collectors.toList());
        //Assert
        assertThat(actual).hasSameSizeAs(expectedElemen).hasSameElementsAs(expectedElemen)
                          .containsExactlyInAnyOrderElementsOf(expectedElemen);
        assertThat(chromWebDriver.getTitle()).isEqualToIgnoringCase("The Internet");
    }

    @AfterEach
    void tearDown () {
        chromWebDriver.quit();
    }
}
