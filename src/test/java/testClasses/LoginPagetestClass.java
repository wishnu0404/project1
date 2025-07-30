package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import baseClass.Baseclass;
import dataprovider.DataProvideClass;
import pageClasses.ForgotpageClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retry.Retry_Analyser;
import utilities.ExcelReadUtility;

public class LoginPagetestClass extends Baseclass {
	@Test(retryAnalyzer = Retry_Analyser.class)
	public void verifySuccessfullLogin() throws IOException {
		LoginPageClass lp = new LoginPageClass(driver);
		HomePageClass hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0,"loginpage"), ExcelReadUtility.getIntegerData(0, 1, "loginpage"));
		hp.clickOnendTourButton();
		String actuLRresult = hp.getTextofWelcomHeading();
		String expectedresult = "Welcome admin";
		Assert.assertTrue(actuLRresult.contains(expectedresult));

	}

	@Test(retryAnalyzer = Retry_Analyser.class)
	public void verifyunSuccessfullLogin() {
		LoginPageClass lp = new LoginPageClass(driver);
		lp.invalidLogin("adm", "123456");
		String actuLRresult = lp.gettextofInvalidErromeesag();
		String expectedresult = "These credentials do not match our records";
		Assert.assertTrue(actuLRresult.contains(expectedresult));

	}
	
	@Test(dataProviderClass = DataProvideClass.class,dataProvider = "unsuccessfullLogin")
	public void verifyInvalidlLogin(String uname, String pass) {
		LoginPageClass lp = new LoginPageClass(driver);
		lp.invalidLogin(uname,pass);
		String actuLRresult = lp.gettextofInvalidErromeesag();
		String expectedresult = "These credentials do not match our records";
		Assert.assertTrue(actuLRresult.contains(expectedresult));

	}


	@Test
	public void verfyUsernameTextboxshowinghintornot() {
		LoginPageClass lp = new LoginPageClass(driver);
		boolean actualresult = lp.getplaceholderattributeofusername("placeholder").isEmpty();
		Assert.assertEquals(actualresult, true);

	}

	@Test
	public void verifyCorrectApplicationisloadingwhileHitting_the_URL() {
		LoginPageClass lp = new LoginPageClass(driver);
		String homepagetext = lp.gettextformtheloginpageofhteapplication();
		String expectedloadedtext = "Demo POS";
		Assert.assertEquals(homepagetext, expectedloadedtext);

	}

	@Test
	public void verify_the_Remebrmecheckboxischeckedby_Default() {
		LoginPageClass lp = new LoginPageClass(driver);
		boolean actualresult = lp.isremebrmecheckboxselctedbydefault();
		Assert.assertFalse(actualresult);
		System.out.println("rmeber mecheck box is selcted " + actualresult);

	}

	@Test
	public void verify_resetPageIsDisplayedWhenClickingForgotPassword() {
		LoginPageClass lp = new LoginPageClass(driver);
		ForgotpageClass fp = lp.clickOnForgotPassword();
		String actualText = fp.getResetPasswordPageText();
		String expectedText = "Reset Password";
		Assert.assertEquals(actualText, expectedText);

	}

}
