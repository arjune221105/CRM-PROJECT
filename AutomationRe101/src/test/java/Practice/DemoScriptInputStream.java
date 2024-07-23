package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.w3c.dom.events.EventException;

import GenericUtility.WebdriverUlitility;

public class DemoScriptInputStream {

	private static final Duration WorkbookFactory = null;

	public static void main(String[] args) throws EventException, IOException {
		FileInputStream pfis =new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties prope = new Properties();
		prope.load(pfis);

		String URL = prope.getProperty("url");
		String BROWSER = prope.getProperty("browser");
		String USERNAME = prope.getProperty("username");
		String PASSWORD = prope.getProperty("password");
		// To Read the data from Excle-File
		FileInputStream efis=new FileInputStream(".\\src\\test\\resources\\Qjspiderdata.xlsx");
		Workbook wb=WorkbookFactory.create(efis);
		
		String LastName = wb.getSheet("Contact").getRow(1).getCell(2).toString();
		
		// Script 
		// Lanch the Browser
		WebdriverUlitility driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new WebdriverUlitility();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new WebdriverUlitility();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new WebdriverUlitility();
		}
		System.out.println("Browser got Lanch Sccessfully");
		driver.manage().window().maximize();
		System.out.println("Browser Maximinize successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
	
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		System.out.println("Name Successfully Lanch");
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		// save and verify
		String lastname = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if (lastname.contains(LastName)) {
			System.out.println(lastname + "pass");
		} else {
			System.out.println(lastname + "fail");
		}
	WebElement LogoutLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

	// Using action class
	 Actions actions=new Actions(driver);
	 actions.moveToElement(LogoutLink).perform();
	 driver.findElement(By.linkText("Sign Out")).click();
	 System.out.println("Browser got Signout Successfully");
	 
	 // close the Browserr
	 driver.quit();
	 System.out.println("Browser sussessfully  Close");

	}

}
