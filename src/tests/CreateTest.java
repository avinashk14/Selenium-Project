package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.CommonMethods;
import common.DataDriverXLS;
import pageobjects.CreateAccountPage;
import pageobjects.HomePage;

public class CreateTest {
	private WebDriver driver;
	public String getURL="http://107.170.213.234/catalog/index.php";
	public CreateAccountPage CreatePage;
	public HomePage HomePage;
	public CommonMethods CM;
	
	@BeforeClass
	public void setUp(){
		CM=new CommonMethods(driver);
		driver=CM.openBrowser("Chrome");
		CM.goToURL(getURL);
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown(){
		CM.closeBrowser();
	}
	
	@Test(dataProvider="testCase", dataProviderClass=TestCases.class)
	public void testLogin(int testCaseNo, DataDriverXLS data){
	CreatePage=new CreateAccountPage(driver);
    CreatePage.Enterdata(testCaseNo, data);
	}
}
