package yoreevo.gen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class First {

    public static void main(String[] args) {

        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        // Create driver object for CHROME browser

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://yoreevo.com/");

        driver.findElement(By.linkText("How it works")).click();
        driver.findElement(By.linkText("Browse listings")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}