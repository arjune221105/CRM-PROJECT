package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import vtiger.Object.Reposerory.HomePage;
import vtiger.Object.Reposerory.LoginPage;

public class BaseClass2 {

	PropertyFileUtility putil = new PropertyFileUtility();
	WebdriverUtility wutil = new WebdriverUtility();

	public WebDriver driver = null;
	
	public static WebDriver sDriver;

	@BeforeSuite
	public void beforsuitclassconfig() {
		Reporter.log(".....Database Connection Exstablished...");

	}
	
	//@Parameters("browsername")
	//@BeforeTest

	@BeforeClass
	public void beforclassconfig(/*String BROWSER*/) throws IOException {
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		// Lanch the Browser
		
		sDriver = driver;// implemetation
		wutil.toMaximize(driver);
		Reporter.log("Browser Maximize Successfully", true);
		wutil.toWaitForElement(driver);
		driver.get(URL);

	}

	@BeforeMethod
	public void beforMethodConfig() throws IOException {
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextfiled().sendKeys(USERNAME);
		lp.getPasswordTextfield().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		Reporter.log("Login Successfully ",true);
	}

	
	@AfterMethod
	public void afterMethodConfig() {
		HomePage hp=new HomePage(driver);
		wutil.toMouseover(driver, hp.getLogoutLink());
		hp.getSingoutlink();
		Reporter.log("Sing out Successfull",true);
	}
	
	
	@AfterClass
	public void afterclssConfig() {
		Reporter.log("Browser got Closed Successfully");
		driver.quit();
	}


	
@Test
public void wrokingfine() {
	Reporter.log("All Working Fine");
}
	
}
