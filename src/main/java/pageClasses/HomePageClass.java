package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;
import utilities.Wait_utilities;

public class HomePageClass {
	WebDriver driver;
	Wait_utilities wait = new Wait_utilities();
	General_Utilities gl = new General_Utilities();

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endTourButton;
	@FindBy(xpath = "//h1[contains(text(),\"Welcome\")]")
	WebElement wlcomeHeading;
	@FindBy(css = "[id ='btnCalculator']")
	WebElement calculatoricon;
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement usermanagement;
	@FindBy(xpath = "//span[contains(text(),'Users ')]")
	WebElement users;
	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement addButton;
	@FindBy(id = "surname")
	WebElement prefix;
	@FindBy(id = "first_name")
	WebElement firstname;
	@FindBy(id = "last_name")
	WebElement lastname;
	@FindBy(id = "email")
	WebElement email;
	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "confirm_password")
	WebElement confirmpassword;
	@FindBy(id = "cmmsn_percent")
	WebElement commissionpercentage;
	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[2]")
	WebElement isActiveCheckbox;
	@FindBy(id = "submit_user_button")
	WebElement submit;

	@FindBy(css = "[type='search']")
	WebElement searchbox;

	@FindBy(xpath = "//table[@id='users_table']/tbody/tr/td")
	List<WebElement> tablename;

	@FindBy(id = "btnCalculator")
	WebElement calculatorbutton;
	@FindBy(id = "digit")
	WebElement numberkey;
	@FindBy(id = "+")
	WebElement plusButton;
	@FindBy(id = "equals")
	WebElement equalsButton;
	@FindBy(css = "[type='text']")
	WebElement result;

	@FindBy(css = "[class='m-8 pull-left mt-15 hidden-xs']")
	WebElement sitedate;

	@FindBy(css = "[class='fa fa-calendar-check-o']")
	WebElement bookingbutton;
	
	@FindBy (xpath = "//a[@id='tour_step6_menu']/span[1]")
	WebElement purcheaseslink;
	@FindBy (xpath ="//li[@id='tour_step6']/ul/li[1]/a")
	WebElement listofpurcheaseslink;

	public void clickOnendTourButton() {
		try {
			if (endTourButton.isDisplayed()) {
				endTourButton.click();
				System.out.println("The element is clicked");
			} else {
				System.out.println("endtoru button is not visible");
			}

		} catch (Exception e) {

			wait.waitfortheElementtoBevisible(driver, endTourButton, 5);

		}
	}

	public String getTextofWelcomHeading() {
		wait.waitfortheElementtoBevisible(driver, wlcomeHeading, 5);
		return wlcomeHeading.getText();

	}

	public String gettooltipofclacluatoricon(String attirbute) {
		return gl.getattributeofelement(calculatoricon, attirbute);

	}

	public void clickOntheUserManagement() {
		usermanagement.click();

	}

	public void clickOnUsers() {
		users.click();
	}

	public void clickOnAddbutton() {
		addButton.click();
	}

	public void fillUserAddForm(String prefixx, String fname, String lname, String mail, String usernam,
			String passwprd, String confirmPass, String commission) {
		prefix.sendKeys(prefixx);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(mail);
		username.sendKeys(usernam);
		password.sendKeys(passwprd);
		confirmpassword.sendKeys(confirmPass);
		commissionpercentage.sendKeys(commission);
	}

	public void checkActivecheckbox() {
		if (!isActiveCheckbox.isSelected())
			isActiveCheckbox.click();
	}

	public HomePageClass save_userFormsubmit() {
		submit.click();
		return new HomePageClass(driver);
	}

	public void searchBoxUserSearching() {
		searchbox.sendKeys("name");
		searchbox.sendKeys(Keys.ENTER);

	}

	public String checktheNameIspresnt() {
		return tablename.get(1).getText();

	}

	public void calcualtorNumberclick(String number) {
		driver.findElement(By.id(number)).click();

	}

	public void calculatorNumberDoubleClick(String number) {
		WebElement button = driver.findElement(By.id(number));
		Actions actions = new Actions(driver);
		actions.doubleClick(button).perform();

	}

	public void culatorClick() {
		calculatorbutton.click();

	}

	public void clickOnPlusButton() {
		plusButton.click();
	}

	public void clickOnEqualsButton() {
		equalsButton.click();
	}

	public String calculatedResult() {
		return result.getAttribute("value");
	}

	public String getSitedate() {
		return sitedate.getText();

	}

	public BookingPageClass clickOntheBookings() {
		bookingbutton.click();
		return new BookingPageClass(driver);

	}
	
	public void purcheasClicktheLinks() {
		purcheaseslink.click();
	}
	
	public PurcheasesPageClass purcheaslistClick() {
		listofpurcheaseslink.click();
		return new PurcheasesPageClass(driver);
	}
	
	

}
