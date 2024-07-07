import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task1 {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setup() {
		String myURL="https://www.saucedemo.com/";
		
		driver.get(myURL);

	}

	@Test(priority = 1)
	public void Log_in() throws InterruptedException {
		Thread.sleep(2000);
		 WebElement username=  driver.findElement(By.id("user-name"));
		 WebElement password= driver.findElement(By.id("password"));

		 WebElement button= driver.findElement(By.id("login-button"));
		
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		button.click();
	}

	@Test(priority = 2)
	public void Products() {

		String ExpectedValue = "Products";
		String TheActualValue = driver.findElement(By.xpath("//span[@data-test='title']")).getText();

		Assert.assertEquals(TheActualValue, ExpectedValue);

	}

	@Test(priority = 3)
	
	public void sorting() throws InterruptedException {
		Thread.sleep(2000);
		 WebElement lowtohigh = driver.findElement(By.className("product_sort_container"));
		 lowtohigh.click();
		 Select Myselector= new Select(lowtohigh);
		 Myselector.selectByVisibleText("Price (low to high)");
		 
		 String TheExpectedTheLowestPrice = "$7.99";

		List<WebElement> thePrices = driver.findElements(By.className("inventory_item_price"));

		//	System.out.println(thePrices.size());

		 String ActuallowestPrice = thePrices.get(thePrices.size() - 1).getText();
			Assert.assertEquals(ActuallowestPrice, TheExpectedTheLowestPrice);


		

	}

}
