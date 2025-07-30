package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;
import utilities.Wait_utilities;
import utilities.WebTableUtility;

public class PurcheasesPageClass {
WebDriver driver;
Wait_utilities wait = new Wait_utilities();
General_Utilities gl = new General_Utilities();
WebTableUtility wb = new WebTableUtility();

public PurcheasesPageClass(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

@FindBy(xpath ="//table[@id='purchase_table']/tbody/tr/td[4]")
List<WebElement> tableRows;



public boolean isItemPresent(String itemName) throws InterruptedException {
	//tableRows.wait();
    return WebTableUtility.isTextPresentInTable(driver, tableRows, itemName);
}
}
	


