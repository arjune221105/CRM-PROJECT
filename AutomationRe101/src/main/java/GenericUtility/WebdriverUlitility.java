package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUlitility {
	
	/**
	 * This method is used to Maximize the Browser
	 * 
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to Minimize Browser
	 * 
	 * @param driver
	 */
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to wait for elements to be loaded in webpage This is to
	 * declare Implicit wait
	 * 
	 * @param driver
	 */
	public void toWaitForElements(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * This method will wait until the element is clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void toElemenetToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait until the element is visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void visiblityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to handle dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void toHandleDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to handle dropdown using value
	 * 
	 * @param element
	 * @param value
	 */
	public void toHandleDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method is used to handle dropdown using visible text
	 * 
	 * @param text
	 * @param element
	 */
	public void toHandleDropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * This method is used to switch driver control to frame using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to Switch driver control to frame using Id or Name
	 * 
	 * @param driver
	 * @param id_name
	 */
	public void toHandleFrame(WebDriver driver, String id_name) {
		driver.switchTo().frame(id_name);
	}

	/**
	 * This method is used to Switch driver control to frame using Webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toHandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch driver control back to immediate parent(frame)
	 * 
	 * @param driver
	 */
	public void toSwitchBackToImmediateParent(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method is used to Switch driver control back to main webpage
	 * 
	 * @param driver
	 */
	public void toSwitchToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to perform mouse hover action provided Webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toMouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform right click provided webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * This method is used to perform double click provided Webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * This method is used to perform drag and drop
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void toDragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, target).perform();
	}

	/**
	 * This method is used to handle alert popup by accepting
	 * 
	 * @param driver
	 */
	public void toHandleAlertPopupByAccepting(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * This method is used to handle alert popup by dismissing it
	 * 
	 * @param driver
	 */
	public void toHandleAlertPopupByDismissing(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * This method is used to capture the text present in Popup and accepting it
	 * 
	 * @param driver
	 * @return
	 */
	public String toCaptureTextInAlertPopup(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String textinPopup = alert.getText();
		alert.accept();
		return textinPopup;
	}
	
	public void toSwitchWindow(WebDriver driver,String partialWindowTitle) {
		
		Set<String> allWindowIds = driver.getWindowHandles();
		
		for(String id :allWindowIds) {
			String windowTitle = driver.switchTo().window(id).getTitle();
			if(windowTitle.contains(partialWindowTitle)) {
				break;
			
			}
		}
		}
		
		public void toTakeScreenShot(WebDriver driver, String screenshotname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			File src = new File("./errorshot/" + screenshotname + ".png");
			org.openqa.selenium.io.FileHandler.copy(temp, src);
	}
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	


