package pages.components;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Categories extends WebComponent {

    @FindBy(css = ".sf-MenuItems-UHHCg2qrE5_YBqDV_7AC")
    public List<WebElement> menuItems;

    @FindBy(css = ".sf-ChildMenuItems-a4G0z3YJJWkQs7qKKuuj")
    public List<WebElement> childMenuItems;

    @FindBy(css = "[class*='sf-ChildMenuItems-KdzkrxSVhcwDy3od0Yre']")
    public List<WebElement> subCategoryItems;
}
