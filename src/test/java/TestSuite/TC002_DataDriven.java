package TestSuite;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.LogoutPage;
import Utilities.DataProviders;

public class TC002_DataDriven extends BaseClass{
	
	@Test(dataProvider="login Data", dataProviderClass=DataProviders.class)
	public void verifyloginDDT(String email, String pwd, String exp) throws InterruptedException {
	LoginPage p=new LoginPage(driver);
	LogoutPage p1=new LogoutPage(driver);
	
	p.setUserName(email);
	
	p.setUserPassword(pwd);
	
	p.clickOnLogin();
	
	
	
	if(isAlertPresent()==true) {
		driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
		Assert.assertTrue(true);
		}
		
	
	else {
		p1.logout();
		Thread.sleep(3000);
		try{
		    System.out.println("Waiting for Alert");
		   
		    wait.until(ExpectedConditions.alertIsPresent()).accept();
		    System.out.println("Alert Displayed");
		}
		catch (Exception e){
		    System.out.println("Alert not Displayed");
		}
        driver.switchTo().defaultContent();
		Assert.assertTrue(true);
	}

	
}
public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
				
		}
	
	}}
