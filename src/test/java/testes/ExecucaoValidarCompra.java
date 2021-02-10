package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ExecucaoValidarCompra extends ValidarCompra {


    @Test
    public void teste() {
        selectProduct();
        cartSummary();
        cartSignIn();
        cartAddress();
        cartShipping();
        cartPayment();
    }

    @Before
    public void initializeTest() {
        initializeTests();

    }

    @After
    public void endTest() {
        driver.close();
    }


}

