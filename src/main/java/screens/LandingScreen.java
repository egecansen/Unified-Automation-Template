package screens;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pickleib.mobile.PickleibScreenObject;

public class LandingScreen extends PickleibScreenObject {

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    public WebElement denyNotificationsButton;

    @FindBy(id = "com.akakce.akakce:id/searchTextView")
    public WebElement searchInputBar;

    @FindBy(xpath = "(//android.widget.EditText[@resource-id=\"com.akakce.akakce:id/searchTextView\"])[2]")
    public WebElement searchInputField;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.akakce.akakce:id/framePopupLyt\"]/android.widget.ImageView")
    public WebElement infoPopUp;

}
