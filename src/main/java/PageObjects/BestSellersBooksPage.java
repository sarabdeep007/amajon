package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class BestSellersBooksPage extends AbstractComponents{
	
	WebDriver driver;
	
	public BestSellersBooksPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1[@class='a-size-large a-spacing-medium a-text-bold']")
	private WebElement bestSellersBooksHeaderBanner;
	
	@FindBy(xpath="//div[@id='zg-left-col']//div[5]//a[1]")
	private WebElement childrensBookLeftNavigationLink;
	

	
	public String verifyBestSellerBooksHeader()
	{
		bestSellersBooksHeaderBanner.isDisplayed();
		return bestSellersBooksHeaderBanner.getText();
	}
	
	public BestSellerBooksChildrensBookPage clickChildrensBookLink()
	{
		childrensBookLeftNavigationLink.isDisplayed();
		childrensBookLeftNavigationLink.click();
		return new BestSellerBooksChildrensBookPage(driver);
	}
	

}
