package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.BestSellersPage;
import PageObjects.HomePage;
import TestComponents.BaseTest;

public class AddBestSellerBookToCart extends BaseTest {

	private HomePage homePage;
	private BestSellersPage bestSellersPage;
	private static final Logger logger = (Logger) LogManager.getLogger(AddBestSellerBookToCart.class);

	@BeforeMethod
	public void methodSetup() {
		homePage = new HomePage(driver);
		bestSellersPage = new BestSellersPage(driver);

	}

	
	@Test 
	public void test2() {
		
		logger.info("Getting the desired ranked book");


		try {
			homePage.clickBestSellersLink().clickBooksLeftNavigationLink().clickChildrensBookLink().getBookByRank(13);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		logger.info("Desired Rank Book found");
		
	}
	
	
		
}	
	
		// List<WebElement> allElements = driver
		//	.findElements(By.xpath("//div[@id='gridItemRoot']//a/following-sibling::a/span/div"));

//	List<WebElement> bestSellerBooks = driver
//			.findElements(By.xpath("//div[@id='gridItemRoot']//div[@class='a-section zg-bdg-ctr']/div/span"));
//	
//	List<WebElement> bookTitles = driver
//				.findElements(By.xpath("//div[@id='gridItemRoot']//a/following-sibling::a/span/div"));
//	
//	//give the second and third book
//
//	// div[@id='B019PIOJYU']//span//div[@class='_cDEzb_p13n-sc-css-line-clamp-1_1Fn1y']
//
//	for (int i = 0; i < bestSellerBooks.size(); i++) {
//		if (bestSellerBooks.get(i).getText().equalsIgnoreCase("#2")) {
//			System.out.println("The number 2 books is: " + bookTitles.get(i).getText());
//			
//		}
//		else if(bestSellerBooks.get(i).getText().equalsIgnoreCase("#3"))
//		{
//			System.out.println("The number 3 books is: " + bookTitles.get(i).getText());
//		}
//	}


	


