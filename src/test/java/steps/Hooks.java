package steps;

import common.PageObject;
import context.ContextStore;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import models.AuthRequestModel;
import models.TokenResponseModel;
import pickleib.mobile.driver.PickleibAppiumDriver;
import pickleib.utilities.screenshot.ScreenCaptureUtility;
import pickleib.web.driver.PickleibWebDriver;
import pickleib.web.driver.WebDriverFactory;
import properties.PropertyUtilities;
import restfulbooker.RestfulBooker;
import static utils.StringUtilities.Color.PURPLE;
import static utils.StringUtilities.highlighted;

public class Hooks extends PageObject {

    public Scenario scenario;
    static Boolean useAppium2;
    public static boolean authorise;
    public static boolean initialiseBrowser;
    public static boolean initialiseAppiumDriver;

    public Hooks(){
        ContextStore.loadProperties("test.properties");
    }

    private void processScenarioTags(Scenario scenario) {
        log.important(scenario.getSourceTagNames().toString());
        this.scenario = scenario;
        authorise = scenario.getSourceTagNames().contains("@Authorize");
        initialiseBrowser = scenario.getSourceTagNames().contains("@Web-UI");
        initialiseAppiumDriver = scenario.getSourceTagNames().contains("@Mobile-UI");
        useAppium2 = Boolean.parseBoolean(ContextStore.get("use-appium2", "false"));
    }

    private WebDriverFactory.BrowserType getBrowserType(Scenario scenario) {
        for (WebDriverFactory.BrowserType browserType : WebDriverFactory.BrowserType.values())
            for (String tag : scenario.getSourceTagNames())
                if (browserType.name().equalsIgnoreCase(tag.replace("@", "")))
                    return browserType;
        return null;
    }

    @Before
    public void initialize(Scenario scenario) {
        processScenarioTags(scenario);
        log.info("Running: " + highlighted(PURPLE, scenario.getName()));

        if (authorise) {
            AuthRequestModel authRequestModel = new AuthRequestModel(
                    PropertyUtilities.getProperty("username"),
                    PropertyUtilities.getProperty("password")
            );
            TokenResponseModel tokenResponse = RestfulBooker.generateToken(authRequestModel);
            ContextStore.put("authToken", tokenResponse.getToken());
        }

        if (initialiseBrowser) {
            WebDriverFactory.BrowserType browserType = getBrowserType(scenario);
            if (browserType != null) PickleibWebDriver.initialize();
            else PickleibWebDriver.initialize();
        }

        if (initialiseAppiumDriver) {
            if (useAppium2) PickleibAppiumDriver.startService();
            PickleibAppiumDriver.initialize();
        }
    }

    @After
    public void kill(Scenario scenario) {
        String screenshotName = null;
        for (String tagName : scenario.getSourceTagNames()) {
            tagName.replace("SCN-", "");
            screenshotName = tagName;
        }

        if (initialiseBrowser) {
            if(scenario.isFailed()) ScreenCaptureUtility.captureScreen(screenshotName, "png", PickleibWebDriver.get());
            PickleibWebDriver.terminate();
        }
        if (initialiseAppiumDriver) {
            if(scenario.isFailed()) ScreenCaptureUtility.captureScreen(screenshotName, "png", PickleibAppiumDriver.get());
            PickleibAppiumDriver.terminate();
        }
    }
}
