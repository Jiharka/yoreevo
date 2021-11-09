package yoreevo.gen.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class MainPage extends AbstractPage {
    @FindBy(linkText = "How it works")
    private WebElement howItWorksLink;

    public HowItWorksPage clickHowItWorksLink() {
        howItWorksLink.click();
        log.info("Click \"How it works\" link in the header");
        return new HowItWorksPage();
    }

    public boolean isResponseFormShown() {
        return !driver.findElements(By.cssSelector("div.freebirdFormviewerViewResponseConfirmContentContainer"))
                .isEmpty();
    }

}
