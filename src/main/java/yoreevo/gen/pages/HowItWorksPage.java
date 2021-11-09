package yoreevo.gen.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class HowItWorksPage extends AbstractPage {
    @FindBy(linkText = "Browse listings")
    private WebElement browseListings;

    public SetupPage clickBrowseListings() {
        browseListings.click();
        log.info("Сlick \"Browse listings\" button within \"browse listings\" section");
        return new SetupPage();
    }
}
