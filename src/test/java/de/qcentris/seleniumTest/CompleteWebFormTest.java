package de.qcentris.seleniumTest;

import de.qcentris.Pages.Authentication.CompleteWebForm;
import de.qcentris.util.EducationLevel;
import de.qcentris.util.Gender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.annotation.Nonnull;
import java.util.List;

import static de.qcentris.util.PageElements.*;
import static org.assertj.core.api.Assertions.assertThat;


class CompleteWebFormTest extends BaseTest {
    @Test
    void testPageHeader () {
        CompleteWebForm completeWebForm = this.testingHomePage.switchToPageWebFrom();
        assertThat(completeWebForm.getPageHeaderText()).isEqualTo("Complete Web Form");
    }

    @ParameterizedTest
    @CsvSource(value = {"Peter,der Hase,Garten Killer", "Panda,Kung Fu, Meister of Kung Fu", "Soumangourou,Kante," +
            "König von Mali"})
    void testFillAllInputField (@Nonnull String expFirstname, @Nonnull String expLastname,
                                @Nonnull String expJobTitle) {
        //Arrange
        //Act
        var completeWebForm = this.testingHomePage.switchToPageWebFrom();
        completeWebForm.setFirstname(expFirstname);
        completeWebForm.setLastname(expLastname);
        completeWebForm.setJobTitle(expJobTitle);
        var actualValues = completeWebForm.getInputValues(INPUT_FIRSTNAME, INPUT_LASTNAME, INPUT_JOB_TITLE);

        //Assert
        assertThat(actualValues).hasSize(3);
        assertThat(actualValues.get(0)).isEqualTo(expFirstname);
        assertThat(actualValues.get(1)).isEqualTo(expLastname);
        assertThat(actualValues.get(2)).isEqualTo(expJobTitle);

    }

    @ParameterizedTest
    @EnumSource(value = EducationLevel.class)
    void testRadioButton (@Nonnull EducationLevel predLevel) {
        //Arrange
        var completeWebForm = this.testingHomePage.switchToPageWebFrom();

        //Act
        completeWebForm.chooseEducationLevel(predLevel);
        var actualResult = completeWebForm.isRadioButtonSelected(predLevel);

        //Assert
        assertThat(actualResult).isTrue();
    }

    @ParameterizedTest
    @EnumSource(value = Gender.class)
    void testCheckBoxGender (@Nonnull Gender expectedGender) {
        //Arrange
        var completeWebForm = this.testingHomePage.switchToPageWebFrom();

        //Act
        completeWebForm.chooseGender(expectedGender);
        var actualCheckedBox = completeWebForm.isCheckBoxSelected(expectedGender);

        //Assert
        assertThat(actualCheckedBox).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void testDropdown (int indexOfeYearOfExp) {
        //Arrange
        var expectedResult = List.of("Select an option", "0-1", "2-4", "5-9", "10+");
        var completeWebForm = this.testingHomePage.switchToPageWebFrom();

        //Act
        completeWebForm.clickDropDownYearOfExperience();
        completeWebForm.selectYearOfExperience(indexOfeYearOfExp);
        var actualSelectedOption = completeWebForm.getSelectedDropdownText();
        var actualDropdownElement = completeWebForm.getDropDownElementText();

        //Assert
        assertThat(actualDropdownElement).containsExactlyInAnyOrderElementsOf(expectedResult);
        assertThat(actualSelectedOption).isEqualTo(expectedResult.get(indexOfeYearOfExp));
    }

    @ParameterizedTest
    @CsvSource(value = {"John,Doe,Lipsum,College,MALE,4,Thanks for submitting your form,The form was successfully " +
            "submitted!"})
    void testAllElementOnPage (@Nonnull String expFirstname, @Nonnull String expLastname, @Nonnull String expJobTitle,
                               @Nonnull EducationLevel expEduLevel, @Nonnull Gender expGender, int expIndexOfYOE,
                               @Nonnull String expHeaderText, @Nonnull String expAlertMsg) {

        //Arrange

        //Act
        var completeWebForm = this.testingHomePage.switchToPageWebFrom();
        completeWebForm.setFirstname(expFirstname);
        completeWebForm.setLastname(expLastname);
        completeWebForm.setJobTitle(expJobTitle);

        completeWebForm.chooseEducationLevel(expEduLevel);
        completeWebForm.chooseGender(expGender);

        completeWebForm.clickDropDownYearOfExperience();
        completeWebForm.selectYearOfExperience(expIndexOfYOE);

        var actual = completeWebForm.clickSubmitButton();


        //Assert
        assertThat(actual).isNotNull().isNotEmpty()
                          .containsExactlyInAnyOrderElementsOf(List.of(expHeaderText, expAlertMsg));

    }
}
