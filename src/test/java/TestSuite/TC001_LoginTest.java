package TestSuite;

import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class TC001_LoginTest extends BaseClass{
	
	@Test
	public void verifyLogin() { 
	log.info("Launching the application");
	LoginPage p=new LoginPage(driver);
	log.info("setting the username");
	p.setUserName(usr);
	log.info("setting  the password");
	p.setUserPassword(pas);
	log.info("clicking on login button");
	p.clickOnLogin();
	//Assert.assertFalse(true);
	log.debug("failed on login button");
	
}
}