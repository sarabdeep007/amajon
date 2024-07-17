package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.BestSellersPage;
import PageObjects.HomePage;
import TestComponents.BaseTest;

public class VerifyBookRank extends BaseTest{
	
	private HomePage homePage;
	private BestSellersPage bestSellersPage;
	private static final Logger logger = (Logger) LogManager.getLogger(VerifyBookRank.class);

	@BeforeMethod
	public void methodSetup() {
		homePage = new HomePage(driver);
		//bestSellersPage = new BestSellersPage(driver);

	}
	
	@Test
	public void test1()
	{
		logger.info("Finding Rank One Boook");
		
		homePage.clickBestSellersLink().clickBooksLeftNavigationLink().clickChildrensBookLink().getTopRankBook();
		
		logger.info("Top rank Book Found");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Hellllo");
	}
	

}
