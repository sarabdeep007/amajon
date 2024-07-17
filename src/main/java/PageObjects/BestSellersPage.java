package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class BestSellersPage extends AbstractComponents {

	WebDriver driver;
	public BestSellersPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Elements Section
	@FindBy(xpath = "//span[@id='zg_banner_text']")
	private WebElement pageHeaderBanner;
	
	@FindBy(xpath="//div[@role='treeitem']//a[contains(text(),'Books')]")
	private WebElement booksLeftNavigationLink;
	
	
	
	
	
	//methods sections
	public String verifyPageHeader()
	{
		
		pageHeaderBanner.isDisplayed();
		pageHeaderBanner.isEnabled();
		return pageHeaderBanner.getText();
		
	}
	
	public BestSellersBooksPage clickBooksLeftNavigationLink()
	{
		booksLeftNavigationLink.isDisplayed();
		booksLeftNavigationLink.isEnabled();
		booksLeftNavigationLink.click();
		return new BestSellersBooksPage(driver);
	}
	

	
	
}
