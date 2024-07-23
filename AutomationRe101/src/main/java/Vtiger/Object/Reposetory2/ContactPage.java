package Vtiger.Object.Reposetory2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	public ContactPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement toclickonContectLookpButton;

	public WebElement getToclickonContectLookpButton() {
		return toclickonContectLookpButton;
	}

	 WebElement getToClickContactPageButton() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
