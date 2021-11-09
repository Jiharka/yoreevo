package yoreevo.gen.pages;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.assertj.core.api.Assertions;

@Slf4j
public class SetupPage extends AbstractPage {
    @FindBy(css = ".setup-cover__details-title")
    private WebElement detailTitle;
    @FindBy(css = ".search-submit-button")
    private WebElement buttonBrowseListings;
    @FindBy(css = ".user.ng-star-inserted")
    private WebElement buttonLogIn;

    public AbstractPage verifyDetailText() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String detailTextActual = detailTitle.getText();
        String detailTextExpected = "I'm Searching In ...";
        log.info("Verifying that details title is displayed and has appropriate text:");
        log.info("Expected text: '{}'", detailTextExpected);
        log.info("Actual text: '{}'", detailTextActual);
        Assertions.assertThat(detailTextActual).isEqualTo(detailTextExpected);
        return this;
    }

    public SetupPage verifyButtonBrowseIsDisabled() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertThat(buttonBrowseListings.getText()).isEqualTo("Browse Listings");

        boolean isDisabledActual = buttonBrowseListings.getAttribute("class").contains("disabled");

        //boolean isEnabledActual = buttonBrowseListings.getAttribute("disabled")!=null;
        log.info("Verifying that button \"Browse listings\" is disabled:");
        log.info("Expected: {}", "true");
        log.info("Actual: {}", isDisabledActual);
        Assertions.assertThat(isDisabledActual).isTrue();
        return this;
    }

    public SetupPage verifyButtonLoginIsEnabled() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertThat(buttonLogIn.getText()).isEqualTo("log in");
        log.info("Verifying that button \"log in\" is displayed ");
        buttonLogIn.click();
        log.info("Click the button \"log in\"");
        boolean displayed = driver.findElement(By.cssSelector(".login-modal")).isDisplayed();
        log.info("Verifying that login window is displayed:");
        log.info("Expected: {}", "true");
        log.info("Actual: {}", displayed);
        Assertions.assertThat(displayed).isTrue();
        return this;
    }

}
