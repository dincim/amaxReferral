package com.ref.amax.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
	
	try {
		
		prop = new Properties();
		
		FileInputStream ip = new FileInputStream("C:\\Users\\MDinc\\eclipse-workspace\\ReferralPageTest"
				+ "\\src\\main\\java\\com\\ref\\amax\\qa\\config\\config.properties");
				
				prop.load(ip);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\browserdrivers\\chromedriver86.exe");
			 driver = new ChromeDriver();
		}else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\browserdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
