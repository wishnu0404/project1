package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;
import utilities.Wait_utilities;
import utilities.WebTableUtility;

public class BookingPageClass {
	WebDriver driver;
	Wait_utilities wait = new Wait_utilities();
	General_Utilities gl = new General_Utilities();
	WebTableUtility wt = new WebTableUtility();

	public BookingPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add_new_booking_btn")
	WebElement addNewBooking;

	@FindBy(xpath = "//table[@id='todays_bookings_table']//thead//th")
	List<WebElement> headings;
	
	@FindBy(xpath ="//div[@class='modal-content']/form//div[1]/h4")
	WebElement modaltitle;

	public void addNewbookingbuttonClick() {
		addNewBooking.click();  // Optional: If you plan to implement it
	}

	public boolean isPresntTheHeadingname(String headingText) {
	    return WebTableUtility.isTextPresentInTable(driver, headings, headingText);
	}
	
	public String getModalTitle() {
	    return modaltitle.getText();
	}

}
	


