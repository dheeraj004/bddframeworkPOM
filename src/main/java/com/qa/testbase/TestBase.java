package com.qa.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.resources.HelperUtility;

public class TestBase {
	
	public static WebDriver driver;
	
	static File file;
    static	FileInputStream fi;
 public static	Properties prop;
	public TestBase()
	{
		file =new File("E:\\Selenium_Practice\\bddframework\\src\\main\\java\\com\\qa\\resources\\confiq.properties");
		
		try {
			fi = new FileInputStream(file);
			prop=new Properties();
			prop.load(fi);
		} catch ( Exception e) {
	
			e.printStackTrace();
		}
		
	}
	
	public static void initilization() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(browsername.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(HelperUtility.implicitlyWaittimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(HelperUtility.pageloadtimeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	

}
