package de.qcentris.seleniumTest;

import de.qcentris.Pages.Authentication.LoginPage;
import de.qcentris.Pages.Authentication.SecureArea;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginAuthenticationTest extends BaseTest {

    @ParameterizedTest
    @CsvSource(value = {"tomsmith,SuperSecretPassword!"})
    void testGoToPageSecureArea (String username, String password) {
        //Arrange
        String expectedPageHeader = "Secure Area";
        String expectedSubHeader = "Welcome to the Secure Area. When you are done click logout below.";
        String expectedAlertMsg = "You logged into a secure area!";
        //Act
        LoginPage loginPage = this.testingHomePage.clickFromAuthentication();
        loginPage.setUsername(username);
        loginPage.setInputPassword(password);
        SecureArea secureArea = loginPage.clickLoginButton();
        //Assert
        assertThat(secureArea.getPageHeaderText()).isEqualToIgnoringCase(expectedPageHeader);
        assertThat(secureArea.getSubHeaderText()).isEqualToIgnoringCase(expectedSubHeader);
        assertThat(secureArea.getAlertStatusText()).containsIgnoringWhitespaces(expectedAlertMsg);
        secureArea.clickLogoutButton();
    }


}
