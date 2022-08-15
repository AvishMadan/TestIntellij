package tests;

import java.io.IOException;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pages.NTHomePage2;
import pages.NTInternationalToursPage;
import pages.NTMyAccount;
import utility.Base;

public class InternationTours extends Base{
    public WebDriver driver;
	NTHomePage2 nt;
	NTInternationalToursPage internationTourObj ;
	Logger log;
	
	
	
	
	
	
	@BeforeMethod
	public void setup() throws IOException {
		log = LogManager.getLogger(InternationTours.class.getName());
		DOMConfigurator.configure("log4j2.xml");
		driver=intialize();
		nt=new NTHomePage2(driver);
		
	}
	
	@Test
	public void verifyParis() throws InterruptedException 
	{  log.error("************There is a error using log4j ********");
		 internationTourObj = nt.internationalTourSelect();	
		 internationTourObj.selectParis();
		 Assert.assertFalse(true);
		 Thread.sleep(4000);
		 String actualValue=internationTourObj.getTextofParis();
		 String ExpectedValue="Paris is the capital and most populous city of France, with an area of 105 square kilometres (41 square miles) and a population of 2,206,488.Since the 17th century, Paris has been one of Europe's major centres of finance, commerce, fashion, science, music and painting.";
		 Assert.assertEquals(actualValue, ExpectedValue);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
