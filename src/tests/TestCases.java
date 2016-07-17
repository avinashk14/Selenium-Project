package tests;

import org.testng.annotations.DataProvider;

import common.DataDriverXLS;

public class TestCases {
	public static String file = "C:/Users/avina/Desktop/data.xlsx";
	public static DataDriverXLS data = new DataDriverXLS(file);
	
	 @DataProvider(name="testCase")
	 public static Object[][] get1Data(){
	     return new Object[][]{{3, data}, {4, data}, {5, data}, {6, data}, {7, data}, {8, data}, {9, data}, {10, data}};
	 }

}
