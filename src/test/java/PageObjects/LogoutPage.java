package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(partialLinkText="Log out") WebElement logout;
	
	public void logout() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logout.click();
		
	}
}
