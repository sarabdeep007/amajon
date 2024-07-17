package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class TelevisionsPage extends AbstractComponents{
	
	WebDriver driver;
	
	public TelevisionsPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Elements
	@FindBy(xpath="//div[@class='puisg-col puisg-col-4-of-12 puisg-col-8-of-16 puisg-col-12-of-20 puisg-col-12-of-24 puis-list-col-right']/div/div")
	private List<WebElement> searchResults;
	
	
	
	
	//methods
	public void getSelectedTV(String tvName)
	{
		for(int i=0; i<searchResults.size(); i++)
		{
			System.out.println(searchResults.get(i).findElement(By.xpath("//h2")).getText());
		}
	}

}
