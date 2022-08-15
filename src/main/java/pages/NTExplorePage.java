package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NTExplorePage {

WebDriver driver;
	
	@FindBy(xpath="//select[@id='sel']")
	public WebElement dropDown;
	
	
	
	public NTExplorePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
	}



	public void selectDropDownValue(String text) 
	{
		Select drop=new Select(dropDown);
		drop.selectByVisibleText(text);
	}
	
}
