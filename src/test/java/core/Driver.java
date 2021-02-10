package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            creatDriver();
        }
        return driver;
    }

    @SuppressWarnings("deprecation")
    public static WebDriver creatDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").concat("\\src\\main\\resources\\webdrivers\\chromedriver.exe"));
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        driver = new ChromeDriver(capabilities);

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
    }

}
