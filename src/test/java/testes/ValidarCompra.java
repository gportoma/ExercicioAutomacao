package testes;

import core.Driver;
import core.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageAutomation;
import pages.PageAutomation;

import java.util.concurrent.TimeUnit;

public class ValidarCompra extends Utils {
    public WebDriver driver;
    private PageAutomation pageAutomation;


    public void initializeTests() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        pageAutomation = new PageAutomation();
        pageAutomation.setDriver(driver);
    }

    private void highLighterMethod(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 6px solid red;');", element);
    }

    public void selectProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(pageAutomation.fadedShortSleev));
        highLighterMethod(driver, pageAutomation.fadedShortSleev);
        takeScreenshot("Step 1");
        pageAutomation.fadedShortSleev.click();
        wait.until(ExpectedConditions.elementToBeClickable(pageAutomation.buttonAddToCart));
        highLighterMethod(driver, pageAutomation.buttonAddToCart);
        takeScreenshot("Step 2");
        pageAutomation.buttonAddToCart.click();
        wait.until(ExpectedConditions.elementToBeClickable(pageAutomation.buttonProceedToCheckout));
        highLighterMethod(driver, pageAutomation.buttonProceedToCheckout);
        takeScreenshot("Step 3");
        pageAutomation.buttonProceedToCheckout.click();
    }

    public void cartSummary() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(pageAutomation.buttonProceedToCheckoutCart));
        highLighterMethod(driver, pageAutomation.buttonProceedToCheckoutCart);
        takeScreenshot("Step 4");
        pageAutomation.buttonProceedToCheckoutCart.click();
    }

    public void cartSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(pageAutomation.fieldEmail));
        pageAutomation.fieldEmail.sendKeys("email@email.email");
        pageAutomation.fieldPwd.sendKeys("tester123");
        wait.until(ExpectedConditions.elementToBeClickable(pageAutomation.buttonSubmitLogin));
        highLighterMethod(driver, pageAutomation.buttonSubmitLogin);
        takeScreenshot("Step 5");
        pageAutomation.buttonSubmitLogin.click();
    }

    public void cartAddress() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(pageAutomation.buttonProceedAddress));
        highLighterMethod(driver, pageAutomation.buttonProceedAddress);
        takeScreenshot("Step 6");
        pageAutomation.buttonProceedAddress.click();
    }

    public void cartShipping() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(pageAutomation.checkTerms));
        highLighterMethod(driver, pageAutomation.checkTerms);
        pageAutomation.checkTerms.click();
        wait.until(ExpectedConditions.elementToBeClickable(pageAutomation.buttonProceedCarrier));
        highLighterMethod(driver, pageAutomation.buttonProceedCarrier);
        takeScreenshot("Step 7");
        pageAutomation.buttonProceedCarrier.click();
    }

    public void cartPayment() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        highLighterMethod(driver, pageAutomation.totalPrice);
        takeScreenshot("Step 8");
        String valorTotal = pageAutomation.totalPrice.getText();
        Assert.assertEquals("$18.51", valorTotal);
    }
}
