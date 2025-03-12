package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties property; 

	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({ "os", "Browser" })
	public void setup(String os, String browser) throws IOException {
		
		//loading config.propertyfiles
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		property = new Properties();
		property.load(file);
		
		
		//logger
		logger = LogManager.getLogger(this.getClass());
		
		//selenium grid setup
		if(property.getProperty("execution_environment").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capability = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				capability.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capability.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("Linux"))
			{
				capability.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("Browser not mentioned");
				return;
			}
			switch(browser.toLowerCase())
			{
			case "chrome":capability.setBrowserName("chrome");break;
			case "firefox":capability.setBrowserName("firefox");break;
			case "edge":capability.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("No matching browser");break;
			}
			driver=new RemoteWebDriver(new URL("http://192.168.1.9:4444/wd/hub"),capability);
			
		}
		
		//for local setup
		
		if(property.getProperty("execution_environment").equalsIgnoreCase("local"))
		{
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid Browser .... ");
			return;
		}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property.getProperty("applicationURL"));//getting the url from config.property file 
		driver.manage().window().maximize();
	}

	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String genearatedString = RandomStringUtils.randomAlphabetic(5);
		return genearatedString;
	}

	public String randomNumber() {
		String genearatedInt = RandomStringUtils.randomNumeric(10);
		return genearatedInt;
	}

	public String randomAlphaNumerals() {
		String genearatedString = RandomStringUtils.randomAlphabetic(5);
		String genearatedInt = RandomStringUtils.randomNumeric(10);
		String generatedAlphaNumerals = genearatedString + "#" + genearatedInt;
		return generatedAlphaNumerals;
	}

	public String captureScreen(String testname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + testname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}
}
