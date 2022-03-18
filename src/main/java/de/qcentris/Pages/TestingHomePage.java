package de.qcentris.Pages;

import de.qcentris.Pages.Authentication.CompleteWebForm;
import de.qcentris.Pages.Authentication.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestingHomePage {
    private final By formAuthentication = By.xpath("//*[@href='/login']");
    private WebDriver driver;
    public TestingHomePage (WebDriver driver){this.driver = driver;}
    public LoginPage clickFromAuthentication(){
        this.driver.findElement(formAuthentication).click();
        return new LoginPage(this.driver);
    }
    public CompleteWebForm switchToPageWebFrom(){
        driver.get("https://formy-project.herokuapp.com/form");
        return new CompleteWebForm(driver);
    }
}
