package Vtiger.Object.Reposetory2;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "user_name")
	private WebElement usernameTextField;

	@FindAll({ @FindBy(xpath = "//input[@type='password']"), @FindBy(name = "user_password") })
	private WebElement passwordnameTextField;

	@FindBy(id = "submitButton")
	private WebElement LoginButton;

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordnameTextField() {
		return passwordnameTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	
	

}
