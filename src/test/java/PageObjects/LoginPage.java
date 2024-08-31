package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath="//input[@name='uid']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='btnLogin']") WebElement loginbutton;
	 
	public void setUserName(String usr) {
		username.sendKeys(usr);
		
	}
	public void setUserPassword(String pass) {
		password.sendKeys(pass);
		
	}
	
	public boolean clickOnLogin() {
		loginbutton.click();
		return true;
		
	}
	
	
	
	
}