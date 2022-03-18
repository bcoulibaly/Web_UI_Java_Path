package de.qcentris.util;

import org.openqa.selenium.By;

public record PageElements() {
    //Element on page https://formy-project.herokuapp.com/form
    public static final By PAGE_HEADER = By.xpath("//div[contains(@class,'container')]/h1");
    public static final By INPUT_FIRSTNAME = By.xpath("//input[contains(@id,'first-name')]");
    public static final By INPUT_LASTNAME = By.xpath("//input[contains(@id,'last-name')]");
    public static final By INPUT_JOB_TITLE = By.xpath("//input[contains(@id,'job-title')]");
    public static final By RADIO_BUTTON_HIGH_SCHOOL = By.xpath("//input[contains(@id,'radio-button-1')]");
    public static final By RADIO_BUTTON_COLLEGE = By.xpath("//input[contains(@id,'radio-button-2')]");
    public static final By RADIO_BUTTON_GRAD_SCHOOL = By.xpath("//input[contains(@id,'radio-button-3')]");
    public static final By CHECK_BOX_MALE = By.xpath("//input[contains(@id,'checkbox-1')]");
    public static final By CHECK_BOX_FEMALE = By.xpath("//input[contains(@id,'checkbox-2')]");
    public static final By CHECK_BOX_NOT_SAY = By.xpath("//input[contains(@id,'checkbox-´3')]");
    public static final By DROP_DOWN_EXPERIENCE = By.xpath("//select[contains(@id,'select-menu')]");
    public static final By INPUT_DATE = By.id("datepicker");
    public static final By SUBMIT_BUTTON = By.xpath("//a[@href='/thanks']");
    public static final By OPTION_OF_EXP_YEARS = By.xpath("//div/select[@id='select-menu']/option");
}
