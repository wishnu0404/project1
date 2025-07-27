package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;
import utilities.General_Utilities;

public class LoginPageClass {

	WebDriver driver;
	General_Utilities gl = new General_Utilities();

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbutton;
	@FindBy(xpath = "//h1[text()='Demo POS']")
	WebElement loginpagetext;
	@FindBy(xpath = "//strong[text()='These credentials do not match our records.']")
	WebElement invalidErrorMessage;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement remebermecheckbox;
	@FindBy(xpath = "//a[@class= 'btn btn-link']")
	WebElement forgotpasswrdlink;
	
	@FindBy(css="[type='search']")
	WebElement searchbox;

	public HomePageClass validLogin(String uname, String pass) {

		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbutton.click();
		return new HomePageClass(driver);
	}

	public LoginPageClass invalidLogin(String uname, String pass) {

		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbutton.click();
		return this; // return LoginPageClass.this;

	}

	public String gettextofInvalidErromeesag() {
		return invalidErrorMessage.getText();

	}

	public String getplaceholderattributeofusername(String attribute) {
		return gl.getattributeofelement(username, attribute);
	}

	public String gettextformtheloginpageofhteapplication() {
		return loginpagetext.getText();

	}

	public boolean isremebrmecheckboxselctedbydefault() {
		return remebermecheckbox.isSelected();
	}

	public ForgotpageClass clickOnForgotPassword () {
		forgotpasswrdlink.click();
		return new ForgotpageClass(driver);
		
	
	}
}
