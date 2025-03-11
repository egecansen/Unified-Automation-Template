package pages;

import common.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.Categories;

public class LandingPage extends PageObject {

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookiesButton;

    @FindBy(css = "[class='sf-MenuItems-QX07tp48Ucqc7rjwhNhx']")
    public WebElement mainMenu;
    @FindBy(css = "[class=\"sf-voltran-body voltran-body full NavigationDesktop\"]")
    public Categories categories;

}
