package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.Baseclass;
import pageClasses.BookingPageClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import utilities.ExcelReadUtility;

public class BookingttestClass extends Baseclass {
	LoginPageClass lp;
	HomePageClass hp;
	BookingPageClass bp;
	
	
  @Test
  public void verifyCustomerHeadingIsPresentInTable() throws IOException {
	  lp = new LoginPageClass(driver);
	  hp = lp.validLogin("admin", "123456");
		hp.clickOnendTourButton();
		bp = hp.clickOntheBookings();
		boolean isCustomerHeadingPresent = bp.isPresntTheHeadingname(ExcelReadUtility.getStringData(0, 1, "searchterms"));
	    Assert.assertTrue(isCustomerHeadingPresent, "'Customer' heading not found in the table");
	  
  }
  
  @Test
  public void verifythemodalisOpening() throws IOException {
	  lp = new LoginPageClass(driver);
	  hp = lp.validLogin("admin", "123456");
		hp.clickOnendTourButton();
		bp = hp.clickOntheBookings();
		bp.addNewbookingbuttonClick();
		String actualresult = bp.getModalTitle();
		String expectedresult = ExcelReadUtility.getIntegerData(1, 1, "searchterms");
		Assert.assertEquals(actualresult, expectedresult);
		System.out.println("the modal is openoing");
  
}
}