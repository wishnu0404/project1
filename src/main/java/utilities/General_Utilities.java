package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class General_Utilities {

	public String getattributeofelement(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public boolean isElementdispleyd(WebElement element) {
		return element.isDisplayed();
	}

	public boolean iselementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean iselementSelected(WebElement element) {
		return element.isSelected();
	}

	public boolean is_Dropdown_Multiselct(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();

	}

	public void select_option_fromDropdown_using_Index(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void select_option_fromDrop_down_using_Value(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void slect_option_fromDrop_down_using_Visbletext(WebElement element, String text) {
		Select select = new Select(element);
		select.deSelectByContainsVisibleText(text);
	}

	public void deselct_option_fromDrop_down_using_Index(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(0);

	}

	public void delect_all_option_from_DropDow(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();

	}

	public List<String> getAllOptionsFromDropDown(WebElement element) {
		Select select = new Select(element);
		return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<String> getAllselctedOptionsFromDropDown(WebElement element) {
		Select select = new Select(element);
		return select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public static List<String> getTextsFromElements(List<WebElement> elements) {
		List<String> texts = new ArrayList();
		for (WebElement element : elements) {
			texts.add(element.getText().trim());
		}
		return texts;
	}

	public void fileUpload(WebElement element, String filepath) {
		element.sendKeys("filepath");

	}

	public void keyDown_Utility(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyDown(key).perform();
	}

	public void keyUp_Utility(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyDown(key).perform();

	}

	public void dragAndDrop_Utility(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, destinationElement).perform();
	}

	public void alert_Acceprt(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void alert_Dismiss(WebDriver driver) {
		Actions actions = new Actions(driver);
		driver.switchTo().alert().dismiss();
	}

	public void proptAlert_inputtext(WebDriver driver, String prompt) {
		driver.switchTo().alert().sendKeys(prompt);
	}

	public String gettextofAletMessage(WebDriver driver) {
		return driver.switchTo().alert().getText();

	}

	public void switchToFrameByNameOrID(WebDriver driver, String NameOrID) {
		driver.switchTo().frame(NameOrID);
	}

	public void switchToFrameByWebelement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchBackfrom_iFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void addSleep_Utility(long timeOut) throws InterruptedException {
		Thread.sleep(timeOut);
	}


}
