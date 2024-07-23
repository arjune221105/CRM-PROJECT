package Vtiger.Object.Reposetory2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContectPageLastName {

	public CreateContectPageLastName(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "lastname")
	private WebElement LastNameTextField;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebutton;

	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

}
