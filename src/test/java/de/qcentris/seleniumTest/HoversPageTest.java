package de.qcentris.seleniumTest;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HoversPageTest extends BaseTest {
    @Test
    @DisplayName("testDiplayCaption - should display the figure caption by hovering over the first figure")
    void testDisplayCaption () {
        //Arrange
        //Act
        val hoverTest = this.testingHomePage.clickHover();
        val figCaption = hoverTest.hoverOverFigure(1);
        //Assert
        assertTrue(figCaption.isFigureCaptionDisplayed());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("testFigCaption- should over the indexed Figure and read the displayed caption")
    void testFigCaption (int index) {
        //Arrange
        val expectedLinkValue = "/users/" + index;
        //Act
        val hoverTest = this.testingHomePage.clickHover();
        val figCaption = hoverTest.hoverOverFigure(index);
        //Assert
        assertTrue(figCaption.isFigureCaptionDisplayed());
        assertThat(figCaption.getTitleText()).isEqualTo("name: user" + index);
        assertThat(figCaption.getLinkValue()).contains(expectedLinkValue).endsWith(expectedLinkValue);
        assertThat(figCaption.getLinkText()).isEqualTo("View profile");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 7, 5, 6})
    @DisplayName("testIOOBE - should throw exception of type IndexOutOfBoundException")
    void testIOOBE (int index) {
        //Arrange
        //Act
        val hoverTest = this.testingHomePage.clickHover();
        //Assert
        assertThrows(IndexOutOfBoundsException.class, () -> hoverTest.hoverOverFigure(index));
    }
}