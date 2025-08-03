package pageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


@FindBy(xpath ="//input[@type ='search']")
WebElement searchbox;

@FindBy(xpath ="//table[@id='purchase_table']/tbody/tr/td[9]/div/button")
WebElement actionbuttons;

@FindBy(xpath ="//table[@id=\"purchase_table\"]/tbody/tr[1]/td[9]/div/ul/li[4]/a")
WebElement dletebutton;

@FindBy(xpath ="//div[@id='purchase_table_info']")
WebElement seaerchresult; 

@FindBy(xpath ="//div[@class='swal-footer']//button[text()='OK']")
WebElement okbutton;
public boolean isItemPresent(String itemName) throws InterruptedException {
	//tableRows.wait();
    return WebTableUtility.isTextPresentInTable(driver, tableRows, itemName);
}


public String seachFortheGiven(String searchitem) {
	searchbox.sendKeys( searchitem);
	searchbox.sendKeys(Keys.ENTER);
	return searchitem;
	
}

public String searchResultCount() {
	return seaerchresult.getText();
}

public void clickOnActionButton() {
	actionbuttons.click();
}
public void clickondletebutton() {
	dletebutton.click();
}


public void confirmDelete() {
	okbutton.click();
}



}

	


