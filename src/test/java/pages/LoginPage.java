package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	// Propiedades
	private WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	// Web Elements
	@FindBy(css = "a.the-header__login")
	private WebElement signInButton;

	@FindBy(id = "username")
	private WebElement inputEmail;

	@FindBy(id = "password")
	private WebElement inputPassword;

	@FindBy(id = "continue")
	private WebElement continueButton;

	@FindBy(id = "next")
	private WebElement loginButton;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement acceptCookiesButton;

	// Metodos
	public void login(String email, String password) {
		if (this.acceptCookiesButton.isDisplayed()) {
			this.acceptCookiesButton.click();
		}

		this.signInButton.click();

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(this.inputEmail));
		this.inputEmail.sendKeys(email);

		this.continueButton.click();

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(this.inputPassword));
		this.inputPassword.sendKeys(password);

		this.loginButton.click();

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(this.acceptCookiesButton));
		this.acceptCookiesButton.click();
	}

}
