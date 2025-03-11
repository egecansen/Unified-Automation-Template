Feature: DIAS - Akakce

  @Mobile-UI @SCN-Akakce-01
  Scenario: Akakce App - Apply filters and add the 10th product from the Laptops section
    * Tap the denyNotificationsButton on the LandingScreen
    * Tap the infoPopUp on the LandingScreen
    * Tap the searchInputBar on the LandingScreen
    * Fill input searchInputField on the LandingScreen with text: Laptop
    * Execute mobile editor command: search
    * Tap the filterButton on the SearchScreen
    * Tap the Bilgisayar, Donanım from the FilterScreen
    * Tap the showResultsButton on the FilterScreen
    * Tap the sortButton on the SearchScreen
    * Tap the highestPriceOption on the SearchScreen
    * Swipe until the listed product index final is visible on the row from the SearchScreen
    * Tap the product numbered 10 on the row from the SearchScreen
    * Verify presence of element goToProductButton on the SearchScreen
    * Tap the goToProductButton on the SearchScreen
    * Verify presence of element goToDistributorButton on the ProductScreen