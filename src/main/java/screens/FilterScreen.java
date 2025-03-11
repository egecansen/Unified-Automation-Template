package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pickleib.mobile.PickleibScreenObject;
import pickleib.mobile.driver.PickleibAppiumDriver;

public class FilterScreen extends PickleibScreenObject {

    @FindBy(id = "com.akakce.akakce:id/applyFilterBtn")
    public WebElement showResultsButton;

    public WebElement getSubCategory(String subCat) {
        return PickleibAppiumDriver.get().findElement(By.xpath("//android.widget.TextView[@text='" + subCat + "']"));
    }

}
