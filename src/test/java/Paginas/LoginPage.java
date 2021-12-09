package Paginas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class LoginPage extends Base {



	@FindBy (id="id_userLoginId")
	WebElement inputEmail;
	
	@FindBy (id="id_password")
	WebElement inputPass;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement buttonLogin;
	
	@FindBy (xpath="//label[@data-uia='label+rememberMe']")
	WebElement rembemberMeForClick;
	
	@FindBy (id="bxid_rememberMe_true")
	WebElement checkboxRembemberME;
	
	@FindBy (xpath="//div[@class='fb-login']//span[1]")
	WebElement loginFacebook;
	
	@FindBy (xpath="//h1[@data-uia='login-page-title']")
	WebElement textSignIn;
	
	@FindBy (xpath="//div[@data-uia='login-field+error']")
	WebElement textErrorSignIn;
	
	WebDriver driver; 
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void setEmail (String email) {
		inputEmail.sendKeys(email);
	}
	
	public void setPass(String pass) {
		inputPass.sendKeys(pass);
	}
	
	public void clickOnLogin () {
		buttonLogin.click();
	}
	
	public WebElement setRememberMe(WebElement rembemberMeForClick) {
		this.rembemberMeForClick=rembemberMeForClick;
		return rembemberMeForClick;
	}
	
	public void clickOnRememberMe() {
		rembemberMeForClick.click();
	}
		
	public String getTextLoginFacebook() {
		return loginFacebook.getText();
	}
	
	public String getTextSigIn() {
		return textSignIn.getText();
	}
	
	public String getTextErrorSigIn() {
		return textErrorSignIn.getText();
	}
	
	public boolean isSelectedOnElementRememberMe() {
		return checkboxRembemberME.isSelected();
	}
}
