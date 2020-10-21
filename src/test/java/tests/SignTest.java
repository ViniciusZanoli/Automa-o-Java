package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class SignTest {
    @Test
    public void testRealizaLogin(){
        System.setProperty("webdriver.chrome.driver", "/home/zanoli/Downloads/chromedriver/chromedriver");
        String login = "vinicius92", password = "123456";

        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navegador.get("http://www.juliodelima.com.br/taskit");

        navegador.findElement(By.linkText("Sign in")).click();
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
        navegador.findElement(By.linkText("SIGN IN")).click();

        String saldacao = navegador.findElement(By.className("me")).getText();

        assertEquals("Hi, Vinicius Zanoli", saldacao);

        navegador.quit();
    }
}
