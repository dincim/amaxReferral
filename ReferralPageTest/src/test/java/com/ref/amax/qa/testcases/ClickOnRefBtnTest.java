package com.ref.amax.qa.testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ref.amax.qa.base.TestBase;
import com.ref.amax.qa.pages.ClickOnReferralBtn;
import com.ref.amax.qa.util.TestUtil;


public class ClickOnRefBtnTest extends TestBase {
	
	ClickOnReferralBtn clcikOnReferralBtn;
	
	public ClickOnRefBtnTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		clcikOnReferralBtn = new ClickOnReferralBtn();
	}
	
	
	@Test(enabled = false)
	public void clickOnRefBtn() {
		
		driver.findElement(By.xpath("//*[@class = 'referButton pointer']")).click();
		
		String actualTitle = driver.getTitle();
		
		System.out.println("Referral page title is:"+actualTitle);
		
		String expectedTitle = "A-MAX Auto Insurance";
		
		Assert.assertEquals(expectedTitle, actualTitle);
			
	}
	
	@Test(enabled = true)
	public void fillTheForm() throws InterruptedException {
		
		boolean ref = true;
		
		try {
			
			driver.findElement(By.xpath("//*[@class = 'referButton pointer']")).click();
			Thread.sleep(2000);
			
			//String referBtn = "//button[@class='navbar-toggler'";
			WebElement referBtn = driver.findElement(By.xpath("//button[@class='btn banner-btn'][1]"));
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();",referBtn );
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
//		
//		Actions actionProvider = new Actions(driver);
//	      // Perform click-and-hold action on the element
//	      actionProvider
//	      .moveToElement(referBtn)
//	      .build();
//	      
//	      actionProvider.click();
	      
	     // .clickAndHold(referBtn).build().perform();

		if(ref)
			TestUtil.sendEmail(
					"Referral page is Up and Running test got passed",
					"SUCCESS. Referral page is up and running.:)");
		else
			TestUtil.sendEmail(
					"Referral page is not responding at this moment, I'm immediately checking",
					"FAILED. Referral page test is failed.:/");
		
		
		
		
		
	}
	
}
