package com.demoqa.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.demoqa.util.AnsiColorUtils;

public class BaseTest extends BaseClass {
    private static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    @Parameters(value = { "browser" })
    public void setUp(@Optional("chrome") String browser) {
        int maxRetries = 3;
        int retryCount = 0;

        while (retryCount <= maxRetries) {
            try {
                init(browser);
                break; // Si la inicialización tiene éxito, salimos del bucle y continuamos con las
                       // pruebas
            } catch (Exception e) {
                if (retryCount == maxRetries) {
                    logger.error(AnsiColorUtils.applyRed("No se pudo inicializar después de " + maxRetries
                            + " intentos. Lanzando excepción.\n" + e));
                    retryCount++;
                } else {
                    retryCount++;
                    logger.error(
                            AnsiColorUtils.applyRed("Reintentando inicializacion (Intento " + retryCount + ")\n" + e));
                }
            }
        }
    }

    @AfterClass
    public void tearDown() {
        quit();
    }
}
