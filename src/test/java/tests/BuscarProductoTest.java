package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MarketplacePage;

public class BuscarProductoTest {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.dnv.com/");
	}

	@Test
	public void test() {
		String email = "lauraantonellagodoy@gmail.com";
		String password = "Pruebatest_1";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(email, password);

		HomePage homePage = new HomePage(driver);
		homePage.irAMarketplace();
		
		MarketplacePage marketPlacePage = new MarketplacePage(driver);
		
		Assert.assertTrue(marketPlacePage.searchAndGetResults("Maritime").contains("Showing results for 'Maritime'"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
