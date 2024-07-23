package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcleFileUtlity;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebdriverUtility;
import Vtiger.Object.Reposetory2.ContactPageInfo;
import Vtiger.Object.Reposetory2.CreateContectPageLastName;
import vtiger.Object.Reposerory.ContactPage;
import vtiger.Object.Reposerory.HomePage;
import vtiger.Object.Reposerory.LoginPage;


public class DemoScriptLoginHomePage {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		PropertyFileUtility putil = new PropertyFileUtility();

		ExcleFileUtlity eutil = new ExcleFileUtlity();

		WebdriverUtility wutil = new WebdriverUtility();

		String URL = putil.toReadDataFromPropertyFile("url");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		String BROWSER = putil.toReadDataFromPropertyFile("browser");

		// Lanch the Browser

		WebDriver driver = null;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		System.out.println("Lanch the Browser Successfully");
		wutil.toMaximize(driver);
		System.out.println("Browser Maximize successfully");
		wutil.toWaitForElement(driver);

		// Login
		driver.get(URL);

		// To Perform Login Page
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextfiled().sendKeys(USERNAME);
		lp.getPasswordTextfield().sendKeys(PASSWORD);
		lp.getLoginButton().click();

		// Navigate to Contact Link
		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();

		// Creat on contact lookup image
		ContactPage cp = new ContactPage(driver);
		cp.getToClickContactPageButton().click();

		// create conteact with manadorty fields
		CreateContectPageLastName ccp = new CreateContectPageLastName(driver);
		String LASTNAME = eutil.toReadDataFromExcleFile("Contact", 1, 2);
		ccp.getLastNameTextField().sendKeys(LASTNAME);
		ccp.getSavebutton().click();

		// Vlidaaters
		ContactPageInfo cip = new ContactPageInfo(driver);
		String lastname = cip.getTocontactPageinfo().getText();
		if (lastname.contains(LASTNAME)) {
			System.out.println(lastname + "....pass");
		} else {
			System.out.println(lastname + "...fail");
		}

		wutil.toMouseover(driver, hp.getLogoutLink());
		hp.getLogoutLink().click();
		System.out.println("Logout Link Successfully");
		driver.quit();
		System.out.println("Sever Quit Successfully");

	}

}
