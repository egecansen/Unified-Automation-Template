package pages.components;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainNavigation extends WebComponent {

    @FindBy(id = "shoppingCart")
    public WebElement shoppingCart;
}
