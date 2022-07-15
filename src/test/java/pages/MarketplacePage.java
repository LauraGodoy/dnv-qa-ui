package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MarketplacePage {
	
	// Propiedades
	private WebDriver driver;

	// Constructor
	public MarketplacePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	// Web Elements
	@FindBy(css = "div.search-area_fcad07 input")
	private WebElement searchMarketplaceInput;
	
	@FindBy(css = "h3.section-title_0a504c")
	private WebElement showingResultsTitle;
	
	public String searchAndGetResults(String searchBy) {
		this.searchMarketplaceInput.sendKeys(searchBy);
		this.searchMarketplaceInput.sendKeys(Keys.ENTER);
		return this.showingResultsTitle.getText();
	}
}
