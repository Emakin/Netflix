package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Base {
	
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
	}
	
	public void esperaImplicita() {
		//Agrego una espera implicita
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public String getTitlePage() {
		return driver.getTitle();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}
	
}
