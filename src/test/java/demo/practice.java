package demo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class practice {
	WebDriver driver;
	WebDriverWait Wait;
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}
	
	@Test
	public void practicePage() throws IOException {
		
		
		boolean actualTitle=driver.getPageSource().contains("Practice Page");
		WebElement roundTrip=driver.findElement(By.xpath("//label[text()='Round Trip']"));
		roundTrip.isSelected();
		
		WebElement form1=driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		form1.sendKeys("del");
		form1.findElement(By.xpath("//a[contains(text(),'Delhi (DEL)']")).click();
		//form1.findElement(By.xpath("//a[@text='Delhi (DEL)']")).click();
		
		WebElement form11=driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		form11.sendKeys("ben");
		form11.findElement(By.xpath("//li[contains(text(),'Bengaluru (BLR)']")).click();
		
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.xpath("//td[date-month='4']")).click();
		
		
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.xpath("//td[data-handler='selectDay']")).click();
		
		WebElement citizenSenior=driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount"));
		if(!citizenSenior.isSelected()) {
			citizenSenior.click();
		}
		driver.findElement(By.id("divpaxinfo")).click();
		
		Select adults=new Select(driver.findElement(By.id("divpaxOptions")));
		adults.selectByValue("2");
		
		Select children=new Select(driver.findElement(By.id("divpaxOptions")));
		children.selectByValue("3");
		
		driver.findElement(By.id("hrefDecAdt")).click();
		
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autosuggest")));
		System.out.println("Flight search");
		
		WebElement banner=driver.findElement(By.cssSelector("img(usemap='#terminal]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollToView(true);",banner);
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		
		File src=banner.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("flights_search.png"));
	}
	@AfterClass
	public void closeAll() {
		driver.quit();
	}

}
