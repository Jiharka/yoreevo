package yoreevo.gen.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static String remoteHostValue = null;
    private static String browser = null;
    private static String platform = null;

    private static String getRemoteHostValue() {
        remoteHostValue = System.getProperty("seleniumServerUrl");
        if (remoteHostValue == null) {
            remoteHostValue = "http://localhost:4444/wd/hub";

        }
        return remoteHostValue;
    }

    private static String getBrowser() {
        browser = System.getProperty("browser");
        if (browser == null) {
            browser = "CHROME";
        }
        return browser;
    }

    private static String getPlatform() {
        platform = System.getProperty("platform");
        if (platform == null) {
            platform = "LINUX";
        }
        return platform;
    }

    static WebDriver setUpDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Browsers
        browser = getBrowser();
        switch (browser) {
            case "FF":
               /* FirefoxProfile fprofile = new FirefoxProfile();
                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability(FirefoxDriver.PROFILE, fprofile);*/
                break;
            case "IE":
               /* capabilities = DesiredCapabilities.internetExplorer();
                // next capability can be set manually in IE
                // http://www.software-testing-tutorials-automation.com/2015/07/how-to-run-selenium-webdriver-test.html
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);*/
                break;
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("chrome.switches", "--disable-extensions");
                options.addArguments("disable-infobars");
                break;
            default:
                throw new Error("Unsupported Browser: " + browser);
        }

        // Platforms
        platform = getPlatform();
        if (platform.equalsIgnoreCase("WINDOWS")) {
            capabilities.setPlatform(Platform.WINDOWS);
        }
        if (platform.equalsIgnoreCase("MAC")) {
            capabilities.setPlatform(Platform.MAC);
        }
        if (platform.equalsIgnoreCase("LINUX")) {
            capabilities.setPlatform(Platform.LINUX);
        }

        remoteHostValue = getRemoteHostValue();
        ChromeOptions options;
        WebDriver driver = new ChromeDriver();//new RemoteWebDriver(new URL(remoteHostValue));
        driver.manage().window().maximize();
        driver.get("https://yoreevo.com/");

        return driver;
    }
}
