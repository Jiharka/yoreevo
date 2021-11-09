package yoreevo.gen.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class WebDriverInstansiator {

    private static InheritableThreadLocal<WebDriver> webDriver = new InheritableThreadLocal<WebDriver>();

    public static void setDriver() throws MalformedURLException {
        webDriver.set(DriverFactory.setUpDriver());
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void tearDown() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
        }
    }
}
