package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.Baseclass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.Login_pageClass;
import utilities.RandomDataGeneration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HomepagetestClass extends Baseclass {
	LoginPageClass lp;
	HomePageClass hp;
  @Test
  public void verfiythetooltipofcalculatoricon() {
	  lp = new LoginPageClass(driver);
	  hp = lp.validLogin("admin", "123456");
		hp.clickOnendTourButton();
		String actualresult = hp.gettooltipofclacluatoricon("data-original-title");
		System.out.println(actualresult);
		String expectedresult = "Calculator";
		Assert.assertEquals(actualresult, expectedresult);
	  
  }
  @Test (invocationCount = 50)
  public void verify_the_user_added_is_displayed() {
	  lp = new LoginPageClass(driver);
	  hp= lp.validLogin("admin", "123456");
	  hp.clickOnendTourButton();
	  hp.clickOntheUserManagement();
	  hp.clickOnUsers();
	  
	  String firstname = RandomDataGeneration.firstName();
	  String Prefix = RandomDataGeneration.getPrefix();
	  String lastname = RandomDataGeneration.lastName();
	  String email = RandomDataGeneration.generateEmail();
	  String username = RandomDataGeneration.generateUsername();
	  String password = RandomDataGeneration.generatePassword();
	  
	  hp.clickOnAddbutton();
	  hp.fillUserAddForm(Prefix, firstname, lastname, email, username, password, password, "2");
	  hp.checkActivecheckbox();
	  hp.save_userFormsubmit();
	 String actualresult= hp.checktheNameIspresnt();
	 String Expectedresult ="Vishnu";
	 System.out.println(actualresult);
	 Assert.assertEquals(actualresult, Expectedresult);
	  }
  
  @Test
  public void verify_the_clacuator_addition() {
	  lp = new LoginPageClass(driver);
	  hp= lp.validLogin("admin", "123456");
	  hp.clickOnendTourButton();
	  hp.culatorClick();
	  hp.calcualtorNumberclick("1");
	  hp.clickOnPlusButton();
	  hp.calculatorNumberDoubleClick("1");
	  hp.clickOnEqualsButton();
	  String actualresult = hp.calculatedResult();
	  String expectedresult = "12";
	  System.out.println("th actualresult is " +actualresult);
	  Assert.assertEquals(actualresult, expectedresult);
  }
  
  @Test
  public void  voidverify_the_Current_date() {
		  lp = new LoginPageClass(driver);
		  hp= lp.validLogin("admin", "123456");
		  hp.clickOnendTourButton();
		  String actualsitedate = hp.getSitedate();
		  LocalDate today = LocalDate.now();
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		  String currentlocaldate = today.format(formatter);
		  Assert.assertEquals(actualsitedate, currentlocaldate);
		  System.out.println("Site date is " +actualsitedate);
		  System.out.println("Local date is " +currentlocaldate);
		  
	  
  }


}
