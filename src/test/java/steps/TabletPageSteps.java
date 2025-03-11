package steps;

import context.ContextStore;
import io.cucumber.java.en.Given;
import pages.TabletPage;
import pages.components.ProductCard;
import utils.StringUtilities;

public class TabletPageSteps {

    TabletPage tabletPage = new TabletPage();

    @Given("Click the most expensive product on the TabletPage")
    public void clickMostExpensiveProduct() {
        tabletPage.log.info("Acquiring the product...");
        ProductCard targetProduct = tabletPage.getHighestPricedProduct(tabletPage.getHighestPrice());

        ContextStore.put("productName", targetProduct.productTitleWithCampaign.getText());
        ContextStore.put("productPrice", targetProduct.currentPrice.getText().replaceAll(" TL", ""));
        tabletPage.log.info("Product name saved to the context as " + StringUtilities.highlighted(StringUtilities.Color.BLUE, ContextStore.get("productName")));
        tabletPage.log.info("Product price saved to the context as " + StringUtilities.highlighted(StringUtilities.Color.BLUE, ContextStore.get("productPrice")));

        tabletPage.centerElement(targetProduct.productTitleWithCampaign);

        tabletPage.log.info("Clicking the add to basket button");
        tabletPage.clickElement(targetProduct.productTitleWithCampaign);
    }
}
