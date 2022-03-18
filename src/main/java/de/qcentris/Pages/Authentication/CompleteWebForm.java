package de.qcentris.Pages.Authentication;

import de.qcentris.util.EducationLevel;
import de.qcentris.util.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.List;

import static de.qcentris.util.PageElements.*;

/**
 * Automate different actions on the page {@linkplain <a href="https://formy-project.herokuapp.com/form">...</a>}
 * using Selenium for Java
 */
public class CompleteWebForm {
    private final WebDriver webDriver;

    public CompleteWebForm (@Nonnull WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     *Set the user first name  on the corresponding field.
     * @param firstName firstname to be set on the field.
     */
    public void setFirstname (@Nonnull String firstName) {
        webDriver.findElement(INPUT_FIRSTNAME).sendKeys(firstName);
    }

    /**
     * This methode set the user last name  on the corresponding field.
     * @param lastName user last name to be set.
     */
    public void setLastname (@Nonnull String lastName) {
        webDriver.findElement(INPUT_LASTNAME).sendKeys(lastName);
    }

    /**
     *
     * @param jobTitle
     */
    public void setJobTitle (@Nonnull String jobTitle) {
        webDriver.findElement(INPUT_JOB_TITLE).sendKeys(jobTitle);
    }

    /**
     *
     * @param eduLevel
     */
    public void chooseEducationLevel (@Nonnull EducationLevel eduLevel) {
        switch (eduLevel) {
            case High_School -> webDriver.findElement(RADIO_BUTTON_HIGH_SCHOOL).click();
            case College -> webDriver.findElement(RADIO_BUTTON_COLLEGE).click();
            default -> webDriver.findElement(RADIO_BUTTON_GRAD_SCHOOL).click();
        }
    }

    /**
     *
     * @param gender
     */
    public void chooseGender (@Nonnull Gender gender) {
        switch (gender) {
            case FEMALE -> webDriver.findElement(CHECK_BOX_FEMALE).click();
            case PREFER_NOT_TO_SAY -> webDriver.findElement(CHECK_BOX_NOT_SAY).click();
            default -> webDriver.findElement(CHECK_BOX_MALE).click();
        }
    }

    /**
     *
     * @param yearOfExperience
     */
    public void selectYearOfExperience (@Nonnull int yearOfExperience) {
        List<WebElement> optionList = webDriver.findElements(OPTION_OF_EXP_YEARS);
        assert (yearOfExperience <= optionList.size());
        optionList.get(yearOfExperience).click();
    }

    /**
     *
     * @return
     */
    public List<String> clickSubmitButton () {
        webDriver.findElement(SUBMIT_BUTTON).click();
        return List.of(webDriver.findElement(By.cssSelector("div.container > h1")).getText(),
                       webDriver.findElement(By.cssSelector("div.container > div.alert")).getText());
    }

    /***
     *
     * @return
     */
    public String getPageHeaderText () {
        return webDriver.findElement(PAGE_HEADER).getText();
    }

    /**
     *
     * @param now
     */
    public void date (@Nonnull LocalDateTime now) {
        //TODO should be implemented soon
    }

    //Getter als Text()

}