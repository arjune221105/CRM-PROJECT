package Vtiger.Object.Reposetory2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnazationPageinfo {

	public OrgnazationPageinfo(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement toOrnazitonPageinfosave;

	public WebElement getToOrnazitonPageinfosave() {
		return toOrnazitonPageinfosave;
	}

	

}
