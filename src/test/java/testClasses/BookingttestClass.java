package testClasses;

import org.testng.annotations.Test;

import baseClass.Baseclass;
import pageClasses.BookingPageClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class BookingttestClass extends Baseclass {
	LoginPageClass lp;
	HomePageClass hp;
	BookingPageClass bp;
	
	
  @Test
  public void verifyThe_booking_Process() {
	  lp = new LoginPageClass(driver);
	  hp = lp.validLogin("admin", "123456");
		hp.clickOnendTourButton();
		bp = hp.clickOntheBookings();
	  bp.addNewbookingbuttonClick();
	  
  }
  
}
