package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NTHomePage2 {
	WebDriver driver;
	NTMyAccount account;
//locators(Instance variable using find by) +Actions(all methods by using we are performing some task on the home page)
	@FindBy(name="username")
	public WebElement userName;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(xpath = "//form[@name='loginform']/button")
	public WebElement submitButton;
	@FindBy(xpath = "//button[@class='w3-button']")
	public WebElement tours;
	@FindBy(xpath = "//a[normalize-space()='International Tour']")
	public WebElement internationalTour;
	
	
	
	
	
	
	
	
//This is your assignment this url should come from property file.
	
	

	public NTHomePage2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public NTMyAccount login(String user, String pass) {
		userName.sendKeys(user);
		password.sendKeys(pass);
		submitButton.click();
		return new NTMyAccount(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void tearDown() {
		driver.quit();
	}
public void alertaccept() {
	Alert ac = driver.switchTo().alert();
	ac.accept();
}

public NTInternationalToursPage internationalTourSelect() 
{
	
tours.click();
internationalTour.click();

return new NTInternationalToursPage(driver);

}

}
