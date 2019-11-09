
package more;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Utils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class NavigateToMoreScreen {
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
        driver.findElementById ("com.hungerstation.android.web.debug:id/more_item").click ();Utils.sleep (4);
    }

    @Test
    public void MorePageWithLoggedinUser () {
        Utils.sleep (1);
        driver.findElementById ("com.hungerstation.android.web.debug:id/orders_item").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/btnaction").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/phone_number").sendKeys ("0500341221");
        Utils.sleep (2);
        driver.findElementById ("com.hungerstation.android.web.debug:id/btn_login").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/edt_verification_number").sendKeys ("000000"); Utils.sleep (2);
        driver.findElementById ("com.hungerstation.android.web.debug:id/more_item").click ();
    }

    @Test
    public void ReturnBack () {
        Utils.sleep (1);
        driver.findElementById ("com.hungerstation.android.web.debug:id/more_item").click ();Utils.sleep (3);
        driver.findElementByClassName ("androidx.drawerlayout.widget.DrawerLayout").click ();Utils.sleep (3);
    }


    @After
    public void tearDown() {

        driver.quit();
        service.stop ();
    }
}
