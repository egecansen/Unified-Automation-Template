package pages.components;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddedToBasketPopUp extends WebComponent {

    @FindBy(css = "[type=\"button\"]:first-of-type")
    public WebElement goToBasket;


}
