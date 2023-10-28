package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	public WebDriver driver;
	Properties properties;
	FileInputStream fileInputStream;
	String propertiesPath = System.getProperty("user.dir")+"/src/main/java/Resources/configData.properties";
	public Logger logger = (Logger)LogManager.getLogger();
	
	public WebDriver initSetup()
	{
		properties = new Properties();
		try {
			fileInputStream = new FileInputStream(propertiesPath);
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String browserName =  (System.getProperty("browser")==null) ? properties.getProperty("browser") : System.getProperty("browser");
		
		switch(browserName)
		{
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable --notifications");
			if("true".equals(System.getProperty("headless")))
			{
				options.addArguments("--headless");
				logger.info("started headless chrome");
			}
			
			driver = new ChromeDriver(options);
			break;
			
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--disable --notifications");
			
			
			if("true".equals(System.getProperty("headless")))
			{
				firefoxOptions.addArguments("-headless");
				logger.info("started headless firefox");
			}
			driver = new FirefoxDriver(firefoxOptions);
			break;
			
		case "safari":
			driver = new SafariDriver();
			break;
			
		default:
			throw new RuntimeException("Browser not properly configured");
				
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		return driver;
		
		
	}
	
	public String getScreenShot(String testName, WebDriver driver)
	{
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"/screenshot/"+testName+".png");
		
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return System.getProperty("user.dir")+"/screenshot/"+testName+".png";
	}
	
	
	
	@BeforeMethod
	public void launchApp()
	{
		if(driver == null)
			driver = initSetup();
		else
			driver = initSetup();
		
		
		
		driver.get(properties.getProperty("url"));
		
		
	
	}
	

	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
			driver.close();
	}

}
