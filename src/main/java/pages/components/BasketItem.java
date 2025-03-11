package pages.components;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketItem extends WebComponent {

    @FindBy(css = "[class=\"product_name_2Klj3\"] a")
    public WebElement productName;

    @FindBy(css = "[class=\"product_price_uXU6Q\"]")
    public WebElement productPrice;


}
