package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.NoSuchElementException;

public class Utils {
    private WebDriver driver = Driver.getDriver();
    private final String screenshotTime = getDatetime();

    /**
     * Método para realizar espera de elemento
     *
     * @param element WebElement - Elemento que deseja esperar
     * @param time    int - Tempo que deseja esperar em segundos
     */
    public void waitElement(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Método para realizar o scroll até o elemento
     *
     * @param element WebElement - Elemento que deseja visualizar
     */
    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * Método para tirar uma screeshot
     *
     * @param fileName String - Nome do arquivo
     */
    public void takeScreenshot(String fileName) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String folderName = "Evidencias";
            FileUtils.copyFile(screenshotFile, new File("src/main/resources/evidencias/" + folderName + "/" + screenshotTime
                    + "/" + fileName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para tirar uma screeshot
     *
     * @return Date - Data e tempo atual
     */
    public String getDatetime() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD_hh-mm-ss", Locale.getDefault());
        return dateFormat.format(date);
    }

}
