package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {
	String url ;
	public WebDriver driver;
	public WebDriver intialize() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\eclipse-workspace\\webdrivertraining\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		url=proppertyFileRead();
		driver.get(url);
		return driver;
	}
	//property file url fetch
	
	public String captureScreenShot(WebDriver driver) 
	{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String location="C:\\Users\\LENOVO\\eclipse-workspace\\printTheData\\screenshot\\"+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(srcfile, new File(location));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return location;
	}
	public String proppertyFileRead() throws IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\end2end\\data.properties");
		Properties properties=new Properties();
		properties.load(fis);
		String url=properties.getProperty("url");
	return url;
	
}
}