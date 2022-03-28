package de.qcentris.Pages;

import de.qcentris.Pages.Authentication.CompleteWebForm;
import de.qcentris.Pages.Authentication.LoginPage;
import de.qcentris.Pages.Hovers.HoversPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestingHomePage {
    private final By formAuthentication = By.xpath("//*[@href='/login']");
    private final By hovers = By.xpath("//*[@href='/hovers']");
    private WebDriver driver;

    public TestingHomePage (WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFromAuthentication () {
        this.driver.findElement(this.formAuthentication).click();
        return new LoginPage(this.driver);
    }

    public HoversPage clickHover () {
        this.driver.findElement(this.hovers).click();
        return new HoversPage(this.driver);
    }

    public CompleteWebForm switchToPageWebFrom () {
        this.driver.get("https://formy-project.herokuapp.com/form");
        return new CompleteWebForm(this.driver);
    }
}
