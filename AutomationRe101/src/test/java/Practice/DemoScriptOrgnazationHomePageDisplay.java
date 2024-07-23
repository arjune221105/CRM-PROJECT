package Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcleFileUtlity;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebdriverUtility;
import Vtiger.Object.Reposetory2.OrgnazationContactPageonAccount;
import Vtiger.Object.Reposetory2.OrgnazationPage;
import Vtiger.Object.Reposetory2.OrgnazationPageinfo;
import vtiger.Object.Reposerory.HomePage;
import vtiger.Object.Reposerory.LoginPage;

public class DemoScriptOrgnazationHomePageDisplay {

	public static void main(String[] args) throws IOException {

		PropertyFileUtility putil = new PropertyFileUtility();// TO read the data
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

		System.out.println("Browser got Lanch Successfully");
		wutil.toMaximize(driver);
		System.out.println("Browser got Maximize Successfully");
		wutil.toWaitForElement(driver);

		driver.get(URL);

		// To Perform Login Page
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextfiled().sendKeys(USERNAME);
		lp.getPasswordTextfield().sendKeys(PASSWORD);
		lp.getLoginButton().click();

		// Navigate to Orgnazation Link

		HomePage hp = new HomePage(driver);
		hp.getOrgnizationlink().click();

		// Create Orgnazation Lookup Image

		OrgnazationPage orgpage = new OrgnazationPage(driver);
		orgpage.getToClickOrgnazationLookupButton().click();

		OrgnazationContactPageonAccount ocp = new OrgnazationContactPageonAccount(driver);
		String LASTNAME = eutil.toReadDataFromExcleFile("Orgnazation", 1, 2);

		ocp.getOrgnazationTextField().sendKeys(LASTNAME);
		ocp.getOrgnazationsavebutton().click();

		// Validators

		OrgnazationPageinfo orgpageinfo = new OrgnazationPageinfo(driver);
		String lastname = orgpageinfo.getToOrnazitonPageinfosave().getText();

		if (lastname.contains(LASTNAME)) {
			System.out.println(lastname + "pass...");
		} else {
			System.out.println(lastname + "fail...");
		}

		wutil.toMouseover(driver, hp.getLogoutLink());

		hp.getLogoutLink();
		System.out.println("Logout Successfully");

		driver.quit();
		System.out.println("close the Server Successfully");
	}

}
