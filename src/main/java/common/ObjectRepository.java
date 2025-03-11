package common;

import pages.*;
import pickleib.utilities.interfaces.repository.PageRepository;
import screens.*;

public class ObjectRepository implements PageRepository {

    //Web Pages
    LandingPage landingPage;
    TabletPage tabletPage;
    ShoppingCartPage shoppingCartPage;
    ProductPage productPage;

    //Mobile Screens
    LandingScreen landingScreen;
    SearchScreen searchScreen;
    FilterScreen filterScreen;
    ProductScreen productScreen;

}
