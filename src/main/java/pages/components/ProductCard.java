package pages.components;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.TextParser;

public class ProductCard extends WebComponent {

    @FindBy(css = "[class*='title-'] span")
    public WebElement productTitle;

    @FindBy(css = "[data-test-id=\"product-card-name\"]")
    public WebElement productTitleWithCampaign;

    @FindBy(css = "[class*='price-'][class*='go']")
    public WebElement price;

    @FindBy(css = "[data-test-id=\"price-current-price\"]")
    public WebElement currentPrice;

    @FindBy(css = "[data-test-id=\"price-area\"]")
    public WebElement addToBasketButton;


    public Double getPrice() {
        return Double.parseDouble(currentPrice.getText().replaceAll(" TL", ""));
    }

    public Double getCurrentPrice() {
        return Double.parseDouble(TextParser.parse("", ",", currentPrice.getText()));
    }
}
