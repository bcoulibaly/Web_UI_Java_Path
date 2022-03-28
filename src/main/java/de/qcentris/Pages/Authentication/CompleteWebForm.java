package de.qcentris.Pages.Authentication;

import de.qcentris.util.EducationLevel;
import de.qcentris.util.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.annotation.Nonnull;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static de.qcentris.util.PageElements.*;

/**
 * Automate different actions on the page <a href="https://formy-project.herokuapp.com/form">...</a>
 * using Selenium for Java
 */
public class CompleteWebForm {
    private final WebDriver webDriver;

    public CompleteWebForm (@Nonnull WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Set the user first name  on the corresponding field.
     *
     * @param firstName firstname to be set on the field.
     */
    public void setFirstname (@Nonnull String firstName) {
        this.webDriver.findElement(INPUT_FIRSTNAME).sendKeys(firstName);
    }

    /**
     * This methode set the user last name  on the corresponding field.
     *
     * @param lastName user last name to be set.
     */
    public void setLastname (@Nonnull String lastName) {
        this.webDriver.findElement(INPUT_LASTNAME).sendKeys(lastName);
    }

    /**
     * @param jobTitle
     */
    public void setJobTitle (@Nonnull String jobTitle) {
        this.webDriver.findElement(INPUT_JOB_TITLE).sendKeys(jobTitle);
    }

    /**
     * @param eduLevel
     */
    public void chooseEducationLevel (@Nonnull EducationLevel eduLevel) {
        switch (eduLevel) {
            case High_School -> this.webDriver.findElement(RADIO_BUTTON_HIGH_SCHOOL).click();
            case College -> this.webDriver.findElement(RADIO_BUTTON_COLLEGE).click();
            case Grad_School -> this.webDriver.findElement(RADIO_BUTTON_GRAD_SCHOOL).click();
            default -> throw new IllegalArgumentException(
                    String.format("the specified education of level %s do not exist.!!", eduLevel));
        }
    }

    /**
     * @param gender
     */
    public void chooseGender (@Nonnull Gender gender) {
        switch (gender) {
            case FEMALE -> this.webDriver.findElement(CHECK_BOX_FEMALE).click();
            case PREFER_NOT_TO_SAY -> this.webDriver.findElement(CHECK_BOX_NOT_SAY).click();
            case MALE -> this.webDriver.findElement(CHECK_BOX_MALE).click();
            default -> throw new IllegalArgumentException(
                    String.format("the specified gender %s do not exist.!!", gender));
        }
    }

    /**
     * @param yearOfExperience
     */
    public void selectYearOfExperience (@Nonnull int yearOfExperience) {
        var optionList = this.webDriver.findElements(OPTION_OF_EXP_YEARS);
        assert (yearOfExperience <= optionList.size());
        optionList.get(yearOfExperience).click();
    }

    /**
     *
     */
    public void clickDropDownYearOfExperience () {
        this.webDriver.findElement(DROP_DOWN_EXPERIENCE).click();
    }

    public String getInputElemValue (By inputElement) {
        return this.webDriver.findElement(inputElement).getAttribute("value");
    }

    public String getSelectedDropdownText () {
        return new Select(this.webDriver.findElement(DROP_DOWN_EXPERIENCE)).getFirstSelectedOption().getText();
    }

    public List<String> getInputValues (By... elementToGetValue) {
        return Arrays.stream(elementToGetValue).map(e -> this.webDriver.findElement(e).getAttribute("value"))
                     .collect(Collectors.toList());
    }

    public boolean isRadioButtonSelected (@Nonnull EducationLevel levelToCheck) {
        boolean result;
        switch (levelToCheck) {
            case High_School -> result = this.webDriver.findElement(RADIO_BUTTON_HIGH_SCHOOL).isSelected();
            case College -> result = this.webDriver.findElement(RADIO_BUTTON_COLLEGE).isSelected();
            case Grad_School -> result = this.webDriver.findElement(RADIO_BUTTON_GRAD_SCHOOL).isSelected();
            default -> throw new IllegalArgumentException(
                    String.format("the specified education of level %s do not exist.!!", levelToCheck));
        }
        return result;
    }

    public boolean isCheckBoxSelected (@Nonnull Gender genderToCheck) {
        boolean result;
        switch (genderToCheck) {
            case PREFER_NOT_TO_SAY -> result = this.webDriver.findElement(CHECK_BOX_NOT_SAY).isSelected();
            case FEMALE -> result = this.webDriver.findElement(CHECK_BOX_FEMALE).isSelected();
            case MALE -> result = this.webDriver.findElement(CHECK_BOX_MALE).isSelected();
            default -> throw new IllegalArgumentException(
                    String.format("the specified gender %s do not exist.!!", genderToCheck));
        }
        return result;
    }

    /**
     * @return
     */
    public List<String> getDropDownElementText () {
        return this.webDriver.findElements(OPTION_OF_EXP_YEARS).stream().map(WebElement::getText)
                             .collect(Collectors.toList());
    }

    /**
     * @return
     */
    public List<String> clickSubmitButton () {
        this.webDriver.findElement(SUBMIT_BUTTON).click();
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return List.of(this.webDriver.findElement(By.cssSelector("div.container > h1")).getText(),
                       this.webDriver.findElement(By.cssSelector("div.container > div.alert")).getText());
    }

    /***
     *
     * @return
     */
    public String getPageHeaderText () {
        return this.webDriver.findElement(PAGE_HEADER).getText();
    }

    /**
     * @param actualDate
     */
    public void date (@Nonnull LocalDateTime actualDate) {
        //TODO should be implemented soon

    }

}