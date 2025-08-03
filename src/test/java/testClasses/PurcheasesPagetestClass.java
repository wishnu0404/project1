package testClasses;

import org.openqa.selenium.support.ui.Wait;
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
	String searcheditem =	pp.seachFortheGiven("ABC_Company");
		pp.isItemPresent(searcheditem);
	//	Assert.assertTrue(true, "item present");
		//pp.clickActionButtonForItem("ABC_Company");
	//	pp.clickActionButtonForItem(searcheditem);
		String paginationcount = pp.searchResultCount();
		System.out.println("the result is " +paginationcount);
		pp.clickOnActionButton();
		pp.clickondletebutton();
		pp.confirmDelete();
		String afterdeleteionpaginationcount = pp.searchResultCount();

	  Assert.assertNotSame(paginationcount, afterdeleteionpaginationcount);
	  System.out.println("the item is dleted");
	  
  }
}
