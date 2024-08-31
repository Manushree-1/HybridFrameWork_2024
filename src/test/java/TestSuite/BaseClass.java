package TestSuite;



import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Properties p;
	 static Logger log;
	public String usr;
	public String pas;
	 WebDriverWait wait;
	
	@BeforeClass
	@Parameters("browser")
	public void setup( String browser) throws IOException{
		
		p=new Properties();
		FileReader fis=new  FileReader("C://temp//InetBanking//src//test//resources//config.properties");
			
				p.load(fis);
		switch(browser.toLowerCase()) 
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		default:System.out.println("Invalid Browser"); return;
		}
		
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		
		log=LogManager.getLogger(this.getClass());
		usr=p.getProperty("username");
     	 pas=p.getProperty("password");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
