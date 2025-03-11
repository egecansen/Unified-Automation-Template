package pages;

import common.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.*;
import pickleib.utilities.element.acquisition.ElementAcquisition;

import java.util.*;

public class TabletPage extends PageObject {

    ElementAcquisition acquisition = new ElementAcquisition();

    @FindBy(css = "#stickyVerticalFilter")
    public WebElement stickyVerticalFilter;

    @FindBy(css = "[class*=\"productsBannerLoader-UswHC1tqx21xH9mUe6Oq\"]")
    public WebElement productBannerLoader;

    @FindBy(css = "#stickyVerticalFilter [data-test-id=\"collapse-title\"]")
    public List<WebElement> filterTitles;

    @FindBy(css = "#stickyVerticalFilter #markalar")
    public GenericFilter brandFilter;

    @FindBy(css = "#stickyVerticalFilter #ekranboyutu")
    public GenericFilter screenResolutionFilter;

    @FindBy(css = "[class=\"productListContent-zAP0Y5msy8OHn5z7T_K_\"]")
    public List<ProductCard> productCards;

    @FindBy(css = "[class=\"hb-toast-content-holder\"]")
    public WebElement addedToBasketBanner;

    @FindBy(css = "[class=\"sf-OldHeader-L1qoqCDGcF7fMecp3DEC\"]")
    public MainNavigation mainNavigation;

    public Double getHighestPrice() {
        Double highestPrice = 0.0;
        for (ProductCard productCard : productCards) {
            if (productCard.getCurrentPrice() > highestPrice) {
                highestPrice = productCard.getCurrentPrice();
            }
        }
        return highestPrice;
    }

    public ProductCard getHighestPricedProduct(Double price) {
        for (ProductCard product : productCards) {
            if (product.getCurrentPrice().equals(price))
                return product;
        }
        throw new RuntimeException("Product not found!");
    }

}
