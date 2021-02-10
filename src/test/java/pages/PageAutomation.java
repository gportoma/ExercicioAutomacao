package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAutomation {

    //LOCATORS SELEÇÃO DE PRODUTO
    @FindBy(linkText = "Faded Short Sleeve T-shirts")
    public WebElement fadedShortSleev;
    @FindBy(xpath = "//button[@name='Submit']")
    public WebElement buttonAddToCart;
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElement buttonProceedToCheckout;

    //LOCATORS CARRINHO SUMARIO
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    public WebElement buttonProceedToCheckoutCart;

    //LOCATORS CARRINHO LOGIN
    @FindBy(xpath = "//input[@id='email']")
    public WebElement fieldEmail;
    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement fieldPwd;
    @FindBy(xpath = "//button[@name='SubmitLogin']")
    public WebElement buttonSubmitLogin;

    //LOCATORS CARRINHO ENDEREÇO
    @FindBy(xpath = "//button[@name='processAddress']")
    public WebElement buttonProceedAddress;

    //LOCATORS CARRINHO ENTREGA
    @FindBy(xpath = "//div[@id='uniform-cgv']/span")
    public WebElement checkTerms;
    @FindBy(xpath = "//button[@name='processCarrier']")
    public WebElement buttonProceedCarrier;

    //LOCATORS CARRINHO PAGAMENTO
    @FindBy(id = "total_price")
    public WebElement totalPrice;


    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
