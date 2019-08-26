package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFirefox {
    private static WebDriver webDriver;

    public static WebDriver getInstance() {
        if (webDriver == null) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            webDriver = new FirefoxDriver();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void destroyInstance() {
        webDriver = null;
    }
}
