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
        // SETA NAS PROPRIEDADES O CAMINHO DO WEB DRIVER QUE BAIXAMOS PARA REALIZAR A AUTOMAÇÃO
        System.setProperty("webdriver.chrome.driver", "/home/zanoli/Documentos/Programas/chromedriver");
        String login = "vinicius92", password = "123456";

        // INSTANCIANDO O CHROMEDRIVER
        WebDriver navegador = new ChromeDriver();

        // MAXIMIZANDO NAVEGADOR.
        navegador.manage().window().maximize();

        // SETA O VALOR DE TIMEOUT, POR CONTA DE QUANDO REALIZADO O LOGIN DEMORA UM POUCO PARA CARREGAR AS INFORMAÇÕES
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // PEGA O SITE QUE SERA TESTADO NA AUTOMAÇÃO
        navegador.get("http://www.juliodelima.com.br/taskit");

        // REALIZA CLICK NO LINK ( Sign in )
        navegador.findElement(By.linkText("Sign in")).click();

        // ENVIA DADOS DO LOGIN
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        // ENVIA DADOS DO PASSWORD
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

        // REALIZA CLICK NO ( SIGN IN" )
        navegador.findElement(By.linkText("SIGN IN")).click();

        // BUSCA VALOR PELA NOME DA CLASSE
        String saldacao = navegador.findElement(By.className("me")).getText();

        assertEquals("Hi, Vinicius Zanoli", saldacao);

//        navegador.quit();
    }
}
