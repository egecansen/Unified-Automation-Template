package pages;

import common.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.BasketItem;

import java.util.List;

public class ShoppingCartPage extends PageObject {

    @FindBy(css = "[class=\"basket_items_3C53o\"]")
    public List<BasketItem> basketItems;

    @FindBy(css = "[d=\"M136 37h579v16H136zm0 22h107v16H136zm0 38h75v20h-75zm129-38h107v16H265zm-15 4h8v8h-8z\"]")
    public WebElement loadingLines;

}
