package Vtiger.Object.Reposetory2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class OrgnazationContactPageonAccount {

	public OrgnazationContactPageonAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "accountname")
	private WebElement orgnazationTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement orgnazationsavebutton;

	public WebElement getOrgnazationTextField() {
		return orgnazationTextField;
	}

	public WebElement getOrgnazationsavebutton() {
		return orgnazationsavebutton;
	}
	
	
	

}
