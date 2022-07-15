package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
	// Propiedades
	private WebDriver driver;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	@FindBy(css = "a.vui-headerLogo")
	private WebElement logoButton;
	
	@FindBy(xpath = "//span[@class=\"vui-listText\" and text()=\"Marketplace\"]")
	private WebElement marketplaceLink;

	public boolean isLogoDisplay() {
		return this.logoButton.isDisplayed();
	}
	
	public void irAMarketplace() {
		this.marketplaceLink.click();
	}
}
