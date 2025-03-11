package steps;

import io.cucumber.java.en.Given;
import pickleib.mobile.interactions.MobileInteractions;
import screens.FilterScreen;
import utils.StringUtilities;

public class FilterScreenSteps extends MobileInteractions {

    FilterScreen filterScreen = new FilterScreen();

    @Given("Tap the {} from the FilterScreen")
    public void click(String subCategory) {
        log.info("Clicking on sub category named " + StringUtilities.highlighted(StringUtilities.Color.BLUE, subCategory));
        filterScreen.clickElement(filterScreen.getSubCategory(subCategory));
    }
}
