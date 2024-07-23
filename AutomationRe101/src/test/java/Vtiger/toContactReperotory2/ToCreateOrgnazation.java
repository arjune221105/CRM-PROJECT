package Vtiger.toContactReperotory2;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass2;
import GenericUtility.ExcleFileUtlity;
import GenericUtility.JavaFileUtility;
import Vtiger.Object.Reposetory2.OrgnazationContactPageonAccount;
import Vtiger.Object.Reposetory2.OrgnazationPage;
import Vtiger.Object.Reposetory2.OrgnazationPageinfo;
import vtiger.Object.Reposerory.HomePage;

@Listeners(GenericUtility.ListunerImplementation.class) // Method
public class ToCreateOrgnazation extends BaseClass2 {

	@Test
	public void TocreateOrgnazationTest_001() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getOrgnizationlink().click();

		OrgnazationPage op = new OrgnazationPage(driver);
		op.getToClickOrgnazationLookupButton().click();

		ExcleFileUtlity eutil = new ExcleFileUtlity();
		JavaFileUtility jutil = new JavaFileUtility();
		String LASTNAME = eutil.toReadDataFromExcleFile("Orgnazation", 1, 2) + jutil.toGetRandonNumber();

		OrgnazationContactPageonAccount opa = new OrgnazationContactPageonAccount(driver);
		opa.getOrgnazationTextField().sendKeys(LASTNAME);
		opa.getOrgnazationsavebutton().click();

		OrgnazationPageinfo opi = new OrgnazationPageinfo(driver);
		String lastname = opi.getToOrnazitonPageinfosave().getText();

//		if(lastname.contains(LASTNAME)) {
//			Reporter.log(lastname+"pass...");
//		}
//		else {
//			Reporter.log(lastname+"fail...");
//		}

		Assert.assertTrue(lastname.contains(LASTNAME));

	}
}
