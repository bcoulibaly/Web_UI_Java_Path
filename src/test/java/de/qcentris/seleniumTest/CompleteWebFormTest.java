package de.qcentris.seleniumTest;

import de.qcentris.Pages.Authentication.CompleteWebForm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.annotation.Nonnull;

import static de.qcentris.util.PageElements.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CompleteWebFormTest extends BaseTest {
    @Test
    void testPageHeader () {
        CompleteWebForm completeWebForm = testingHomePage.switchToPageWebFrom();
        assertThat(completeWebForm.getPageHeaderText()).isEqualTo("Complete Web Form");
    }

    @Test
    @ParameterizedTest
    @CsvSource(value = {"Peter,der Hase,Garten Killer","Panda,Kung Fu, Meister of Kung Fu","Soumangourou,Kante,König von Mali"})
    void testFillAllInputField(@Nonnull String expFirstname, @Nonnull String expLastname,@Nonnull String expJobTitle){
        //Arrange
        //Act
        CompleteWebForm completeWebForm = testingHomePage.switchToPageWebFrom();
        completeWebForm.setFirstname(expFirstname);
        completeWebForm.setLastname(expLastname);
        completeWebForm.setJobTitle(expJobTitle);
        String actualFirstname = getWebElement(INPUT_FIRSTNAME).getAttribute("value");
        String actualLastname = getWebElement(INPUT_LASTNAME).getAttribute("value");
        String actualJobTitle = getWebElement(INPUT_JOB_TITLE).getAttribute("value");
        //Assert
        assertThat(actualFirstname).isEqualTo(expFirstname);
        assertThat(actualLastname).isEqualTo(expLastname);
        assertThat(actualJobTitle).isEqualTo(expJobTitle);

    }
}
