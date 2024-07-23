package Vtiger.Object.Reposetory2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnazationPage {
	
	public OrgnazationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy( xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement toClickOrgnazationLookupButton;

	public WebElement getToClickOrgnazationLookupButton() {
		return toClickOrgnazationLookupButton;
	}
	
	

}
