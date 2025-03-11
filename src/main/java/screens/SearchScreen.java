package screens;

import context.ContextStore;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pickleib.enums.Direction;
import pickleib.mobile.PickleibScreenObject;

import java.util.*;

public class SearchScreen extends PickleibScreenObject {

    @FindBy(id = "com.akakce.akakce:id/filterArea")
    public WebElement filterButton;

    @FindBy(id = "com.akakce.akakce:id/sortArea")
    public WebElement sortButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.akakce.akakce:id/sort_name\" and @text=\"En Yüksek Fiyat\"]")
    public WebElement highestPriceOption;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.akakce.akakce:id/detailBtnTextView\"]")
    public WebElement goToProductButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.akakce.akakce:id/name\"]")
    public List<WebElement> products;

    public void swipeToNthElement(List<WebElement> elementList, Object targetIndexValue) {
        int currentIndex = 0;
        int targetIndex;
        long currentTime = System.currentTimeMillis();

        if (targetIndexValue.equals("final")) {
            targetIndex = elementList.size();
            log.info("Target index configured as " + targetIndex);
        } else targetIndex = (int) targetIndexValue;
        while (currentIndex <= targetIndex && System.currentTimeMillis() - currentTime < elementTimeout) {
            List<WebElement> visibleElements = elementList;
            if (visibleElements.isEmpty()) {
                throw new NoSuchElementException("No elements found on the screen.");
            }
            try {
                for (WebElement element : visibleElements) {
                    if (currentIndex == targetIndex - 1) {
                        scrollInDirection(Direction.up);
                        log.info("Swiping through " + (targetIndex) + "th element: " + element.getText());
                    }
                    currentIndex++;
                }
            } catch (NoSuchElementException e) {
                log.info("Cannot scroll further, element not found.");
                break;
            }
        }
    }

    public void tapTheNthElement(List<WebElement> elementList, int targetIndexValue) {
        int currentIndex = 0;
        long currentTime = System.currentTimeMillis();

        while (currentIndex <= targetIndexValue && System.currentTimeMillis() - currentTime < elementTimeout) {
            List<WebElement> visibleElements = elementList;
            if (visibleElements.isEmpty()) {
                throw new NoSuchElementException("No elements found on the screen.");
            }
            for (WebElement element : visibleElements) {
                if (currentIndex == targetIndexValue) {
                    log.info("Clicking the " + (targetIndexValue) + "th element: " + element.getText());
                    clickElement(element);
                    ContextStore.put("productName", element.getText());
                    return;
                }
                currentIndex++;
            }
            try {
                scrollInDirection(Direction.up);
            } catch (NoSuchElementException e) {
                log.info("Cannot scroll further, element not found.");
                break;
            }
        }
        throw new RuntimeException("Couldn't click on element!");
    }

}
