import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class activityOne {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    //Elements
    String tutorialActivity = "//android.widget.FrameLayout/android.widget.RelativeLayout/" + "android.widget.FrameLayout/android.widget.ImageView";

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 2 API 24 AutomaticTests");
        caps.setCapability("udid", "emulator-5554"); // Źródło: CMD -> "adb devices"
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "ab.java.programming");
        caps.setCapability("appActivity", "ab.java.programming.Startup");
        caps.setCapability("appActivity", "ab.java.programming.MainActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void basicTest() throws InterruptedException {
        //Pomiń Startup activity
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.GridView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.RelativeLayout[1]/android.widget.TextView[3]"))).click();


        MobileElement buttonx = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.RelativeLayout[2]/android.widget.TextView[2]"));

        Assert.assertTrue(buttonx.isDisplayed(), "Element is not displayed.");
        buttonx.click();

        Thread.sleep(10000);


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
