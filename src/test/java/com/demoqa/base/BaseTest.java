package com.demoqa.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends BaseClass {
    private static Logger logger= LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    @Parameters(value = { "browser" })
    public void setUp(@Optional("chrome") String browser) {
        int maxRetries = 3;
        int retryCount = 0;

        while (retryCount < maxRetries) {
            try {
                init(browser);
                break; // Si la inicialización tiene éxito, salimos del bucle y continuamos con las
                       // pruebas
            } catch (Exception e) {
                retryCount++;
                logger.error("Reintentando inicializacion (Intento " + retryCount + ")"+e);
            }
        }

        if (retryCount == maxRetries) {
            logger.error("No se pudo inicializar después de " + maxRetries + " intentos. Lanzando excepción.");
        }
    }

    @AfterMethod
    public void tearDown() {
        quit();
    }
}
