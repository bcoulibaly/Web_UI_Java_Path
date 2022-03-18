package de.qcentris.Pages.Authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private  WebDriver driver;
    private final By inputUsername = By.xpath("//form[contains(@id,'login')]//input[contains(@id,'username')]") ;
    private final By inputPassword = By.xpath("//form[contains(@id,'login')]//input[contains(@id,'password')]") ;
    private final By loginButton = By.xpath("//form[contains(@id,'login')]//button[contains(@class,'radius')]");
    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }
   public void setUsername(String username){
        driver.findElement(inputUsername).sendKeys(username);
    }
    public void setInputPassword(String password){ driver.findElement(inputPassword).sendKeys(password);}
    public SecureArea clickLoginButton(){ driver.findElement(loginButton).click(); return new SecureArea(driver);}
}
