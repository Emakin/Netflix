package Paginas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class LadingPage extends Base {

	WebDriver driver;
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement buttonLogin;
	
	@FindBy(id="id_email_hero_fuji")
	WebElement inputEmailLading;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement buttonStart;
	
	
	String tagNameElement="button";
	
	public LadingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void clickOnInputEmail() {
		inputEmailLading.click();
	}
	
	public String getTag() {
		return tagNameElement;
		
	}
	
	public void setEmail (String email) {
		inputEmailLading.sendKeys(email);
	}
	
	public void clickOnButtonStart() {
		buttonStart.click();
	}
	
	public void clickOnButtonLogin() {
		buttonLogin.click();
	}
	
	
}
