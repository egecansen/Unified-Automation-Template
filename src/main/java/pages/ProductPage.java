package pages;

import common.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.AddedToBasketPopUp;

public class ProductPage extends PageObject {

    @FindBy(css = "[data-test-id=\"default-price\"]")
    public WebElement price;

    @FindBy(css = "[data-test-id=\"addToCart\"]")
    public WebElement addToCartButton;

    @FindBy(css = "[class=\"checkoutui-SalesFrontCash-UqBFhChdjCX02lFgPVLK\"]")
    public AddedToBasketPopUp addedToBasketPopUp;

}
