package steps;

import context.ContextStore;
import io.cucumber.java.en.Given;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pickleib.enums.Direction;
import pickleib.mobile.interactions.MobileInteractions;
import screens.SearchScreen;
import java.util.List;

public class SearchScreenSteps extends MobileInteractions {

    SearchScreen searchScreen = new SearchScreen();

    @Given("Swipe until the listed product index {} is visible on the row from the SearchScreen")
    public void swipeToNthElement(Object targetValue) {
        searchScreen.swipeToNthElement(searchScreen.products, targetValue);
    }

    @Given("Tap the product numbered {} on the row from the SearchScreen")
    public void tapNthElement(int targetIndex) {
        searchScreen.tapTheNthElement(searchScreen.products, targetIndex);
    }

}
