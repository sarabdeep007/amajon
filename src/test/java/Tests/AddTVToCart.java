package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.TelevisionsPage;
import Resources.Constants;
import TestComponents.BaseTest;

public class AddTVToCart extends BaseTest {
	
	
	private HomePage homePage;
	private TelevisionsPage televisionsPage;
	Logger logger = LogManager.getLogger(AddTVToCart.class);
	
	@BeforeMethod
	public void methodSetup()
	{
		homePage = new HomePage(driver);
		televisionsPage = new TelevisionsPage(driver);
	}
	
	@Test
	public void findTv()
	{
		homePage.getSearchResults(Constants.TV_TO_SEARCH);
		logger.info("TV name entered to search");
		televisionsPage.getSelectedTV(Constants.TV_TO_SELECT);
		logger.info("TV selected");
		
		
	}

}
