package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NTMyAccount {
	WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Sign out']")
	public WebElement signOut;
	
	@FindBy(xpath="//div[@id='context']")
	public WebElement mediaBox;
	
	@FindBy(xpath="//a[normalize-space()='Explore']")
	public WebElement explore;
	
	
	
	
	public NTMyAccount(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public NTHomePage2 signOutClick() 
	{
	signOut.click();
	
	return new NTHomePage2(driver);
	}
	public String mediaBoxText() 
	{
		
	return mediaBox.getText();
	}
	
	public NTExplorePage exploreClick() 
	{
		
		
		explore.click();
		
		return new NTExplorePage(driver);
		
	}
	

}
