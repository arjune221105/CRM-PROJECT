package Vtiger.toContactReperotory2;





import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass2;
import GenericUtility.ExcleFileUtlity;
import Vtiger.Object.Reposetory2.ContactPage;
import Vtiger.Object.Reposetory2.ContactPageInfo;
import Vtiger.Object.Reposetory2.HomePage;
import vtiger.Object.Reposerory.CreateContactPage;


@Listeners(GenericUtility.ListunerImplementation.class)// Method
public class Tocreatecontect extends BaseClass2 {

	@Test
	public void toCreateContectTest_001() throws EncryptedDocumentException, IOException  {
		HomePage hp =new HomePage(driver);
		hp.getContactLink().click();

		// Contact Page

		ContactPage cp = new ContactPage(driver);
		cp.getToclickonContectLookpButton().click();

		ExcleFileUtlity eutil = new ExcleFileUtlity();
		String LASTNAME = eutil.toReadDataFromExcleFile("Contact", 1, 2);

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextField().sendKeys(LASTNAME);
		ccp.getSaveButtonLastname().click();
		
		///Assert.fail();

		ContactPageInfo cpfo = new ContactPageInfo(driver);
		String lastname = cpfo.getTocontactPageinfo().getText();
		
/*	if(lastname.contains(LASTNAME)) {
		Reporter.log(lastname+"pass...");
	}
	else {
		Reporter.log(lastname+"fail..");
	}
	
	*
		
		Assert.assertTrue(lastname.contains(LASTNAME));

	}

}
