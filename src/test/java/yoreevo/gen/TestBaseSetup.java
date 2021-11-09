package yoreevo.gen;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import yoreevo.gen.driver.WebDriverInstansiator;

import java.net.MalformedURLException;

public class TestBaseSetup {

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        WebDriverInstansiator.setDriver();
    }

    @AfterClass
    public static void tearDown() {
        WebDriverInstansiator.tearDown();
    }
}
