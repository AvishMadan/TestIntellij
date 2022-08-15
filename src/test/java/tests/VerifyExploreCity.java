package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.NTExplorePage;
import pages.NTHomePage2;
import pages.NTMyAccount;
import utility.Base;

public class VerifyExploreCity extends Base {
	NTHomePage2 nt;
	NTMyAccount myAccountObj;
	public WebDriver driver;
	@BeforeMethod
	public void setup() throws IOException {
		driver=intialize();	
	}
	@Test
	public void selectCity() 
	{
		myAccountObj=nt.login("stc123", "12345");
		NTExplorePage ntExplorePageObj = myAccountObj.exploreClick();
		ntExplorePageObj.selectDropDownValue("Delhi");
       	//You need to click on List and verify the text is should same.
	}
}
