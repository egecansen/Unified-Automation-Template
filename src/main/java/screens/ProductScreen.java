package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pickleib.mobile.PickleibScreenObject;

public class ProductScreen extends PickleibScreenObject {

    @FindBy(id = "com.akakce.akakce:id/detailBtnTextView")
    public WebElement goToDistributorButton;

}
