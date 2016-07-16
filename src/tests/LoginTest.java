package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import common.CommonMethods;
import common.DataDriverXLS;

public class LoginTest {

		public String file = "C:/Users/korukollu/workspace/Project/data.xlsx";
		private WebDriver driver;
		public String getURL="http://107.170.213.234/catalog/index.php";
		public LoginPage LoginPage;
		public HomePage HomePage;
		public CommonMethods CM;
		public DataDriverXLS data = new DataDriverXLS(file);
		public String name, pwd;
		
		@BeforeMethod
		public void setUp(){
			System.out.println("Start");
			CM=new CommonMethods(driver);
			driver=CM.openBrowser("Chrome");
			CM.goToURL(getURL);
		}
		
		@AfterMethod(alwaysRun=true)
		public void tearDown(){
			System.out.println(data.getRowCount("Sheet1"));
			CM.closeBrowser();
		}

		@Test
		public void testLogin(){
		HomePage = new HomePage(driver);
		HomePage.clickLogyourselfLink();
	    LoginPage=new LoginPage(driver);
	    for(int i=0; i< data.getRowCount("Sheet1"); i++)
	    {
	    	System.out.println("test :" + i);
		LoginPage.Login(data.getCellData("Sheet1", 1, i), data.getCellData("Sheet1", 2, i));
	    }
		//CM.verifyText("Welcome to iBusiness");
		//HomePage.clickLogOff();		
		}
}
