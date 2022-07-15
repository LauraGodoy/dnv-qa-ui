package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
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

		Assert.assertTrue(new HomePage(driver).isLogoDisplay());

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
