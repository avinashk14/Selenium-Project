package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import common.DataDriverXLS;

public class CreateAccountPage {
	private WebDriver driver;
	public DataDriverXLS data;
	private Select select;
	
	public  CreateAccountPage(WebDriver driver){
		this.driver=driver;
		driver.get("http://107.170.213.234/catalog/create_account.php");
	    Assert.assertEquals("My Account Information", driver.findElement(By.cssSelector("h1")).getText());
	}
	
	public void Enterdata(int row, DataDriverXLS data)
	{
		select = new Select(driver.findElement(By.name("country")));
		
		if(data.getCellData("CreateData", 2, row).toString().equals("M"))
			driver.findElement(By.xpath("//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[1]/td[2]/input[1]")).click();
		else if (data.getCellData("CreateData", 2, row).toString().equals("F"))
			driver.findElement(By.xpath("//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[1]/td[2]/input[2]")).click();
		
		for (int col=3; col< 19; col++)
		{
			if(col == 13)
				select.selectByVisibleText(data.getCellData("CreateData", col, row));
			else
				driver.findElement(By.name(data.getCellData("CreateData", col, 1).toString())).sendKeys(data.getCellData("CreateData", col, row).toString());
		}
		
		if(data.getCellData("CreateData", 17, row).toString().equals("Y"))
			driver.findElement(By.name("newsletter")).click();
		Test(row, data);
	}
	
	public void Test(int row, DataDriverXLS data)
	{
		driver.findElement(By.id("tdb4")).click();
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		simpleAlert.accept();
		String actual = alertText.substring(alertText.lastIndexOf("*") + 1);
		String expected = data.getCellData("CreateData", 19, row).toString();
		Assert.assertEquals(actual.substring(0, actual.length()-1), expected);
	}
}
