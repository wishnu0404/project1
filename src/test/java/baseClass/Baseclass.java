package baseClass;

import org.testng.annotations.Test;

import constants.ConstantsClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod; 

public class Baseclass {
	public static WebDriver driver;
	public static Properties property;

	public static void readProperty() throws IOException {
		property = new Properties();
		//FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
		FileInputStream file = new FileInputStream(ConstantsClass.filepath);
		property.load(file);
	}
    @Parameters("Browser")
    
	@BeforeMethod (groups = {"tearup"}) 
	public void beforeMethod(String browserValue) throws IOException {
		readProperty();
		if (browserValue.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if (browserValue.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else {
			throw new IllegalArgumentException("Browser Not Supported." + browserValue);
		}
		
		driver.get(property.getProperty("Base_URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConstantsClass.implicitwaittimeduration));

	}

	@AfterMethod (groups = {"teardown"})
	public void afterMethod() {
	driver.quit();
	}

}
