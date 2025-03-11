package pages.components;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GenericFilter extends WebComponent {

    @FindBy(css = "[class=\"searchbox-QPllurtahpWx_ITtdjvg\"]")
    public WebElement filterInput;

    @FindBy(css = "[class=\"seoAnchorLink-nCW0yP4qoVI_AhEjVAY_\"]")
    public List<WebElement> checkBoxes;

    @FindBy(css = "[data-test-id=\"vertical-scroll-filter\"]")
   public WebElement container;

    @FindBy(css = "[data-test-id=\"collapse-title\"]")
    public WebElement title;

}
