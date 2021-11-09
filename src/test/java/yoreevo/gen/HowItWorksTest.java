package yoreevo.gen;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import yoreevo.gen.pages.HowItWorksPage;
import yoreevo.gen.pages.MainPage;
import yoreevo.gen.pages.SetupPage;

public class HowItWorksTest extends TestBaseSetup {
//[How it works] As a guest user click "Browse" listings button within "browse listings" section
    /*Preconditions:
       - User is on home page
       - User is not logged in*/

    private MainPage mainPage;
    private HowItWorksPage howItWorksPage;
    private SetupPage setupPage;

    @BeforeClass
    private void instantiatePage() {
        mainPage = new MainPage();
        howItWorksPage = new HowItWorksPage();
        setupPage = new SetupPage();
    }

    @Test
    public void browseListingsTest() {
        mainPage.clickHowItWorksLink();
        howItWorksPage.clickBrowseListings();
        setupPage.verifyDetailText();
        setupPage.verifyButtonBrowseIsDisabled();
        setupPage.verifyButtonLoginIsEnabled();
    }
}
