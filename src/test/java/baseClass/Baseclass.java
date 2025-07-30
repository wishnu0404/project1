package baseClass;

import org.testng.annotations.Test;

import constants.ConstantsClass;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod; 

public class Baseclass {
	public WebDriver driver;
	public static Properties property;

	public static void readProperty() throws IOException {
		property = new Properties();
		//FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
		FileInputStream file = new FileInputStream(ConstantsClass.filepath);
		property.load(file);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		readProperty();
		driver = new ChromeDriver();
		driver.get(property.getProperty("Base_URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConstantsClass.implicitwaittimeduration));

	}

	@AfterMethod
	public void afterMethod() {
	//	driver.quit();
	}

}
