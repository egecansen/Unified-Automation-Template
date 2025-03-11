package pages.components;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScreenResolutionFilter extends WebComponent {

    @FindBy(css = "[data-test-id=\"vertical-scroll-filter\"]")
    public WebElement brandsContainer;

}
