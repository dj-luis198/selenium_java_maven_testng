package com.demoqa.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends BaseClass {

    @BeforeClass
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
                e.printStackTrace();
                retryCount++;
                System.out.println("Reintentando inicialización (Intento " + retryCount + ")");
            }
        }

        if (retryCount == maxRetries) {
            System.out.println("No se pudo inicializar después de " + maxRetries + " intentos. Lanzando excepción.");
            throw new RuntimeException("No se pudo inicializar después de varios reintentos");
        }
    }

    @AfterClass
    public void tearDown() {
        quit();
    }
}
