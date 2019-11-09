
package more;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class NavigateToMoreScreen {

//
    public  static AppiumDriverLocalService service;
    private AndroidDriver driver;

    @Before
    public void setUp () throws MalformedURLException {

       service = AppiumDriverLocalService.buildService (
                new AppiumServiceBuilder ().usingDriverExecutable(new File ("/usr/local/bin/node"))
                        .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File (System.getProperty("user.dir")+"/src/test/resources/Logs/More.log")));
        service.start (); // check the logs folder

        File app = new File(System.getProperty ("user.dir") + "/App/app-debug.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability ("platformName", "android");
        desiredCapabilities.setCapability ("platformVersion", "8.0");
        desiredCapabilities.setCapability ("deviceName", "Huaweip10lite");
        desiredCapabilities.setCapability ("app", app.getAbsolutePath ());
        URL remoteUrl = new URL ("http://localhost:4723/wd/hub");
        driver = new AndroidDriver (remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (driver.findElementById("com.android.packageinstaller:id/permission_allow_button").isDisplayed()) {
            driver.findElementById ("com.android.packageinstaller:id/permission_allow_button").click ();
        }
    }




    @Test
    public void MorePageWithGustUser () {
        Utils.sleep (1);
        driver.findElementById ("com.hungerstation.android.web.debug:id/smallLabel").click ();

    }
    @Test
    public void MorePageWithLoggedinUser () {
        Utils.sleep (1);
        /*driver.findElement(By.xpath("//td[contains(text(),'Item 1')]"));*/
        driver.findElementById ("com.hungerstation.android.web.debug:id/smallLabel").click ();

    }
    @After
    public void tearDown() {

        driver.quit();
        service.stop ();
    }

}
