package Netflix.Netflixtest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Paginas.LadingPage;
import Paginas.LoginPage;

import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetflixTest {
	String url ="https://www.netflix.com/";
	WebDriver driver;
	
	
	
	@BeforeSuite
	public void setUp() {
		//configuración de las propiedades del chrome Driver
				System.setProperty("webdriver.chrome.driver", "..//Netflixtest//Drivers//chromedriver.exe");
				//instancio el chrome drive
				driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void irURl() {
		//ir a la página
		driver.get(url);
		
	}
	
	@BeforeClass
	public void maxVentana() {

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); //Borro cooki
	}
	

	
	@Test(priority=4)
	public void validarTituloTest() {
		
		LadingPage ladingpage = new LadingPage (driver);
		ladingpage.esperaImplicita();
		String titleString=ladingpage.getTitlePage();
		//Valido el titulo de la misma	
		assertEquals(titleString, "Netflix Argentina: Ve series online, ve películas online");
		
		
	}
	
	@Test(priority=3)
	public void starSessionPageTest() {
		LadingPage ladingpage = new LadingPage(driver);
		ladingpage.clickOnButtonLogin();
		LoginPage loginpage = new LoginPage (driver);
		loginpage.esperaImplicita();
		
		String titleString = loginpage.getTitlePage();
		String textStringLoginFacebook = loginpage.getTextLoginFacebook();
		String textSingIn = loginpage.getTextSigIn();
		
		//Valido el título de la página		
		assertEquals(titleString, "Netflix");

		//Valido el texto de iniciar sesión con facebook
		assertEquals(textStringLoginFacebook, "Iniciar sesión con Facebook");
		
		//Valido el texto iniciar sesión del h1
		assertEquals(textSingIn, "Inicia sesión");
	
		
	}
	
	@Test(priority=2)
	public void loginToNetflixErrorTest() {
		
		LadingPage ladingpage = new LadingPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		ladingpage.esperaImplicita();
		ladingpage.clickOnButtonLogin();
		
		
		loginPage.setEmail("xxx");
		loginPage.setPass("holamundo");
		loginPage.clickOnRememberMe();
		loginPage.clickOnLogin();
		
		loginPage.esperaImplicita();
		
		String errorTextSinIn = loginPage.getTextErrorSigIn();
		
		//Verifico el mensaje de error
		assertEquals(errorTextSinIn, "Escribe un email válido.");
		//Valido que el checkbox este seleccionado
		
		assertTrue(loginPage.isSelectedOnElementRememberMe());
		
		
	}
	
	@Test(priority=1)
	public void fakeEmailTest() {
		
		LadingPage ladingpage = new LadingPage(driver);
		ladingpage.esperaImplicita();
		ladingpage.clickOnInputEmail();
		//Genero un email random
		String email = ladingpage.randomEmail();
		
		ladingpage.setEmail(email);
		
		ladingpage.clickOnButtonStart();
		ladingpage.esperaImplicita();
		System.out.println(email);
		
		//Valido que dentro de la url se encuentre la palabra signup
		String currentURL = driver.getCurrentUrl();
		assertTrue(currentURL.contains("signup"));
		
			
}
	@Test
	public void printTagsTest () {
		LadingPage lading = new LadingPage(driver);
		String tagname = lading.getTag();
		List<WebElement> etiquetas = driver.findElements(By.tagName(tagname));
		
		if(etiquetas.size()!=0) {
		for(int i=0; i<etiquetas.size();i++) {
			System.out.println(etiquetas.get(i).getText());
		}
		}else {
			System.out.println("No se encuentra elementos con está etiqueta");
		}
		
	}
	
	@AfterTest
	public void closed() {
		driver.close();
	}
	
}

