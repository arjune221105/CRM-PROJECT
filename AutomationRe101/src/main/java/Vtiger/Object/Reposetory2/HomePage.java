package Vtiger.Object.Reposetory2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "Organizations")
	private WebElement orgnazationLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	WebElement LogoutLink;

	@FindBy(linkText = "Sign Out")
	private WebElement SingoutLink;

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getOrgnazationLink() {
		return orgnazationLink;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}

	public WebElement getSingoutLink() {
		return SingoutLink;
	}
	
	

}
