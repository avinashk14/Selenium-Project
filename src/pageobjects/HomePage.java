package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	private WebDriver driver;
	  
		public  HomePage(WebDriver driver){
			this.driver=driver;
			String ExpectedText="Welcome to iBusiness";
		    String ActualText=driver.findElement(By.cssSelector("h1")).getText();
		    System.out.println("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
		    Assert.assertEquals(ExpectedText,ActualText);
		}
		
		public void clickLogyourselfLink(){
			driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
			//clickByXpath("//*[@id='bodyContent']/div/div[1]/a[1]/u");
			System.out.println("click login link");
			
		}
		
		public void clickCreateLink(){
			driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[2]/u")).click();
			//clickByXpath("//*[@id='bodyContent']/div/div[1]/a[1]/u");
			System.out.println("click create link");
		}
		
		public void clickLogOff(){
			driver.findElement(By.xpath("//*[@id='tdb4']/span")).click();
			System.out.println("click the log off ");
			   
		}
}
