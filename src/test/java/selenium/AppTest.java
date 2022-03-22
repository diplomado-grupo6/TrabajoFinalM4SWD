package selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @Test
    public void testDxc1()
    {
        String sueldoActual = "1000000";
        String montoAhorrado = "5000000";
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("http://localhost:8080/formulario.html");
        driver.manage().window().setSize(new Dimension(719, 696));
        driver.findElement(By.id("sueldo_actual")).click();
        driver.findElement(By.id("sueldo_actual")).sendKeys(sueldoActual);
        driver.findElement(By.id("monto_ahorrado")).sendKeys(montoAhorrado);

        String saldoActualInput = driver.findElement(By.id("sueldo_actual")).getAttribute("value");
        String montoAhorradoInput = driver.findElement(By.id("monto_ahorrado")).getAttribute("value");

        assertEquals(sueldoActual, saldoActualInput);
        assertEquals(montoAhorrado, montoAhorradoInput);

        driver.findElement(By.cssSelector(".w-100")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[2]/td[2]")));
        String dxc = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[2]/td[2]")).getText();
        String saldo = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[3]/td[2]")).getText();
        String impuesto = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[4]/td[2]")).getText();

        assertEquals(dxc, "$1000000");
        assertEquals(saldo, "$4000000");
        assertEquals(impuesto, "$10010");
    }

    @Test
    public void testDxc2()
    {
        String sueldoActual = "500000";
        String montoAhorrado = "1000000";
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("http://localhost:8080/formulario.html");
        driver.manage().window().setSize(new Dimension(719, 696));
        driver.findElement(By.id("sueldo_actual")).click();
        driver.findElement(By.id("sueldo_actual")).sendKeys(sueldoActual);
        driver.findElement(By.id("monto_ahorrado")).sendKeys(montoAhorrado);

        String saldoActualInput = driver.findElement(By.id("sueldo_actual")).getAttribute("value");
        String montoAhorradoInput = driver.findElement(By.id("monto_ahorrado")).getAttribute("value");

        assertEquals(sueldoActual, saldoActualInput);
        assertEquals(montoAhorrado, montoAhorradoInput);

        driver.findElement(By.cssSelector(".w-100")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[2]/td[2]")));
        String dxc = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[2]/td[2]")).getText();
        String saldo = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[3]/td[2]")).getText();
        String impuesto = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[4]/td[2]")).getText();

        assertEquals(dxc, "$1000000");
        assertEquals(saldo, "$0");
        assertEquals(impuesto, "$0");
    }

    @Test
    public void testDxc3()
    {
        String sueldoActual = "2000000";
        String montoAhorrado = "30000000";
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("http://localhost:8080/formulario.html");
        driver.manage().window().setSize(new Dimension(719, 696));
        driver.findElement(By.id("sueldo_actual")).click();
        driver.findElement(By.id("sueldo_actual")).sendKeys(sueldoActual);
        driver.findElement(By.id("monto_ahorrado")).sendKeys(montoAhorrado);

        String saldoActualInput = driver.findElement(By.id("sueldo_actual")).getAttribute("value");
        String montoAhorradoInput = driver.findElement(By.id("monto_ahorrado")).getAttribute("value");

        assertEquals(sueldoActual, saldoActualInput);
        assertEquals(montoAhorrado, montoAhorradoInput);

        driver.findElement(By.cssSelector(".w-100")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[2]/td[2]")));
        String dxc = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[2]/td[2]")).getText();
        String saldo = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[3]/td[2]")).getText();
        String impuesto = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[4]/td[2]")).getText();

        assertEquals(dxc, "$3000000");
        assertEquals(saldo, "$27000000");
        assertEquals(impuesto, "$63366");
    }

    @Test
    public void testDxc4()
    {
        String sueldoActual = "9000000";
        String montoAhorrado = "2000000";
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("http://localhost:8080/formulario.html");
        driver.manage().window().setSize(new Dimension(719, 696));
        driver.findElement(By.id("sueldo_actual")).click();
        driver.findElement(By.id("sueldo_actual")).sendKeys(sueldoActual);
        driver.findElement(By.id("monto_ahorrado")).sendKeys(montoAhorrado);

        String saldoActualInput = driver.findElement(By.id("sueldo_actual")).getAttribute("value");
        String montoAhorradoInput = driver.findElement(By.id("monto_ahorrado")).getAttribute("value");

        assertEquals(sueldoActual, saldoActualInput);
        assertEquals(montoAhorrado, montoAhorradoInput);

        driver.findElement(By.cssSelector(".w-100")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[2]/td[2]")));
        String dxc = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[2]/td[2]")).getText();
        String saldo = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[3]/td[2]")).getText();
        String impuesto = driver.findElement(By.xpath("//p[@id=\'Resultado\']/table/tbody/tr[4]/td[2]")).getText();

        assertEquals(dxc, "$1000000");
        assertEquals(saldo, "$1000000");
        assertEquals(impuesto, "$1854877");
    }
}
