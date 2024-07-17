package AbstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageObjects.BestSellersPage;

public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	//Elements Sections---
	@FindBy(xpath="//a[normalize-space()='Best Sellers']")
	private WebElement bestSellersLink;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchButton;
	
	
	
	//methods Sections---
	public BestSellersPage clickBestSellersLink()
	{
		bestSellersLink.isDisplayed();
		bestSellersLink.isEnabled();
		bestSellersLink.click();
		return new BestSellersPage(driver);
	}
	
	public void getSearchResults(String itemToSearch)
	{
		searchTextBox.isDisplayed();
		searchTextBox.sendKeys(itemToSearch);
		searchButton.click();
		
	}
}
