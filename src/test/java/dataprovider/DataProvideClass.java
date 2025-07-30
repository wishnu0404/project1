package dataprovider;

import org.testng.annotations.Test;

import utilities.ExcelReadUtility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvideClass {

	@DataProvider(name = "unsuccessfullLogin")
	public Object[][] dp() throws IOException {
		return new Object[][] 
			{ new Object[] {ExcelReadUtility.getStringData(1,0, "loginpage"), ExcelReadUtility.getIntegerData(1,1, "loginpage")}, 
		new Object[] {ExcelReadUtility.getStringData(2,0, "loginpage"), ExcelReadUtility.getIntegerData(2,1, "loginpage")}, 
		new Object[] { "adm", "1256" }};
				
				
	}
}
