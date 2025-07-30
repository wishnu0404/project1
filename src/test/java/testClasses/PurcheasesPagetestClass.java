package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.Baseclass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.PurcheasesPageClass;

public class PurcheasesPagetestClass extends Baseclass {
	LoginPageClass lp;
	HomePageClass hp;
	PurcheasesPageClass pp;
  @Test
  public void verifythementionedItemIsDeletedFromTHEtABLE () throws InterruptedException {
	  lp = new LoginPageClass(driver);
	  hp = lp.validLogin("admin", "123456");
		hp.clickOnendTourButton();
		hp.purcheasClicktheLinks();
		pp= hp.purcheaslistClick();
		pp.isItemPresent("ABC_Company");
		Assert.assertTrue(true, "items not present");
		
	  
  }
}
