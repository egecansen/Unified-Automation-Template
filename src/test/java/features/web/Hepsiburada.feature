Feature: DIAS - Hepsiburada

  @Web-UI @SCN-Hepsiburada-01
  Scenario: Chrome - Add the most expensive 13.2 inch Apple Tablet product to the basket and verify the price
    * Navigate to url: https://www.hepsiburada.com
    * Scroll up using Web driver
    * Hover over listed component element Elektronik of Categories from menuItems list on the LandingPage
    * Hover over listed component element Bilgisayar/Tablet of Categories from childMenuItems list on the LandingPage
    * Click exact element named Tablet amongst subCategoryItems list from Categories component on the LandingPage
    * Wait for absence of element productBannerLoader on the TabletPage
    * Scroll down using Web driver
    * Center element named Ekran Boyutu on the filterTitles from TabletPage
    * Scroll in stickyVerticalFilter container until Marka element is found from filterTitles list on TabletPage
    * Scroll down using Web driver
    * Scroll in container container and click Apple element from checkBoxes list of brandFilter component on TabletPage
    * Refresh the page
    * Wait for absence of element productBannerLoader on the TabletPage
    * Scroll in stickyVerticalFilter container until Ekran Boyutu element is found from filterTitles list on TabletPage
    * Scroll in container container and click 13,2 inç element from checkBoxes list of screenResolutionFilter component on TabletPage
    * Refresh the page
    * Wait for absence of element productBannerLoader on the TabletPage
    * Click the most expensive product on the TabletPage
    * Switch to the next tab
    * Verify the text of price on the ProductPage contains: CONTEXT-productPrice
    * Verify the text of price on the ProductPage contains: CONTEXT-productPrice
    * Click the addToCartButton on the ProductPage
    * Click component element goToBasket of AddedToBasketPopUp component on the ProductPage
    * Wait for absence of element loadingLines on the ShoppingCartPage
    * Select listed component by productName named CONTEXT-productName from basketItems component list on the ShoppingCartPage and verify that it has CONTEXT-productName value for its innerText attribute
    * Select component by productName named CONTEXT-productName from basketItems component list on the ShoppingCartPage and verify productPrice element contains CONTEXT-productPrice text
    * Wait 3 seconds
