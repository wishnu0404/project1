package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;
import utilities.Wait_utilities;

public class BookingPageClass {
	WebDriver driver;
	Wait_utilities wait = new Wait_utilities();
	General_Utilities gl = new General_Utilities();

	public BookingPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add_new_booking_btn")
	WebElement addNewBooking;

	public void addNewbookingbuttonClick() {
		addNewBooking.click();
	}
}
