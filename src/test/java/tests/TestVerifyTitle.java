package tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NTHomePage2;
import pages.NTMyAccount;
import utility.Base;

public class TestVerifyTitle extends Base {
	NTHomePage2 nt;
	NTMyAccount myAccountObj;
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException {
		driver=intialize();	
		nt=new NTHomePage2(driver);
	}
	
	@Test(enabled = false)
	public void titlecheck() 
	{
		
		nt.login("stc123", "12345");
		String actualTitle=nt.getTitle();
		String expectedTitle="My account";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void signOutValidation() throws InterruptedException 
	{
		
		 myAccountObj = nt.login("stc123", "12345");
		 myAccountObj.signOutClick();
		Thread.sleep(5000); 
	//	nt.login("stc123", "12345").signOutClick();
		
		 
	}
	@Test(enabled = false)
	public void multipleLogin() {
		
		nt.login("stc123", "12345").
		signOutClick().
		login("stc123", "12345").
		mediaBoxText();
	}
	
	 @Test
	public void mediaTextValidation() 
	{
		
		 myAccountObj = nt.login("stc123", "12345");
		String text = myAccountObj.mediaBoxText();
	   if(text.contains("Hello! Connect with us on facebook"))
	   {
		   Assert.assertTrue(true);
	   }
	   else 
	   {   
		   Assert.assertTrue(false);
	   }		 
	}
	
	
	
	/*
	 * @Test public void titlecheckWithIncorrectData() {
	 * 
	 * nt.login("stc123", "123"); nt.alertaccept(); String
	 * actualTitle=nt.getTitle(); String expectedTitle="STC Tourism";
	 * Assert.assertEquals(actualTitle, expectedTitle); }
	 */
	
	@AfterMethod
	public void tear() {
	nt.tearDown();
	}

}
