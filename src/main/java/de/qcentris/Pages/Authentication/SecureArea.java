package de.qcentris.Pages.Authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureArea {
    private WebDriver driver;
    private final By pageHeader = By.cssSelector("div.example > h2");
    private final By subHeader = By.cssSelector("div.example > h4.subheader");
    private final By logoutButton = By.cssSelector("div.example > a.button");
    private final By alertDialog = By.id("flash");

    public SecureArea (WebDriver driver) {
        this.driver = driver;
    }

    public String getPageHeaderText () {
        return driver.findElement(pageHeader).getText();
    }

    public String getSubHeaderText () {
        return driver.findElement(subHeader).getText();
    }

    public void clickLogoutButton () {
        driver.findElement(logoutButton).click();
    }

    public String getAlertStatusText () {
        return driver.findElement(alertDialog).getText();
    }

}
