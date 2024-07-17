package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.AbstractComponents;

public class BestSellerBooksChildrensBookPage extends AbstractComponents{

WebDriver driver;
Actions action;
	
	public BestSellerBooksChildrensBookPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		
	}
	
	@FindBy(xpath="//div[@id='gridItemRoot']//a/following-sibling::a/span/div")
	private List<WebElement> allElements;
	
	@FindBy(xpath="//div[@id='gridItemRoot']//div[@class='a-section zg-bdg-ctr']/div/span")
	private List<WebElement> bestSellerBooks;
	
	@FindBy(xpath="//div[@id='gridItemRoot']//a/following-sibling::a/span/div")
	private List<WebElement> bookTitles;
	
	@FindAll({
			@FindBy(xpath="//li/a[text()='Next page']"),
			@FindBy(xpath="//li[@class='a-disabled a-last']")
			})
	private WebElement nextButton;
	
	By bestSellerBooksLocator = By.xpath("//div[@id='gridItemRoot']//div[@class='a-section zg-bdg-ctr']/div/span");

	public void getBookByRank(int requestedRank) throws InterruptedException
	{
		
		
		int oldCount = 0;
		int newCount = bestSellerBooks.size();
		boolean noNewElements = false; 
		
		
		while(oldCount<newCount && !noNewElements)
		{
			oldCount=newCount;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			
			 try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // wait for a maximum of 20 seconds
				 wait.until(ExpectedConditions.
						 numberOfElementsToBeMoreThan(By.xpath("//div[@id='gridItemRoot']//a/following-sibling::a/span/div"), newCount));
				 
				// bestSellerBooks = driver.findElements(By.xpath("//div[@id='gridItemRoot']//a/following-sibling::a/span/div"));
				 newCount = bestSellerBooks.size();
				
				 
				
//				 if(nextButton.isDisplayed() && nextButton.isEnabled())
//				 {
//					 nextButton.click();
//				 }
				
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				noNewElements = true;  // set the flag to true if no new elements found after scrolling and waiting
			    
			}
		}
		
		
		
		
		
		
		    
		
		
		System.out.println("the maximum length of rank list is: "+bestSellerBooks.size());
		for(int i=0; i<bestSellerBooks.size(); i++)
		{
			
			if(requestedRank> Integer.parseInt(bestSellerBooks.get(bestSellerBooks.size()-1).getText().substring(1)))
			{
				System.out.println("this rank does not exists for the requested products list.");
				System.out.println("The maximum rank on this page is: "+bestSellerBooks.get(bestSellerBooks.size()-1).getText());
				break;
			}
			else if(bestSellerBooks.get(i).getText().equalsIgnoreCase("#"+requestedRank))
			{
				System.out.println("The number "+requestedRank+" books is: " + bookTitles.get(i).getText());
			}
				 
		}
		
	}
	
	
	public String getTopRankBook()
	{
		for(int i=0; i<bestSellerBooks.size(); i++)
		{
			if(bestSellerBooks.get(i).getText().equalsIgnoreCase("#1"))
			{
				return bookTitles.get(i).getText();
			}
					 
		}
		return "Book Not Found";
	}
	
//	for (int i = 0; i < bestSellerBooks.size(); i++) {
//	if (bestSellerBooks.get(i).getText().equalsIgnoreCase("#2")) {
//		System.out.println("The number 2 books is: " + bookTitles.get(i).getText());
//		
//	}
//	else if(bestSellerBooks.get(i).getText().equalsIgnoreCase("#3"))
//	{
//		System.out.println("The number 3 books is: " + bookTitles.get(i).getText());
//	}
//}



	
}
