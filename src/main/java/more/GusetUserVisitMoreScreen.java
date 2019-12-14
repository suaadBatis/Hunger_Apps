package more;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Utils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GusetUserVisitMoreScreen {

    private static final String Suaad_ScreenShot=("./ScreenShots/");
    public static AppiumDriverLocalService service;
    private static AndroidDriver driver;

    @Before
    public  void setUp () throws IOException{
        service = AppiumDriverLocalService.buildService (
                new AppiumServiceBuilder ().usingDriverExecutable (new File ("/usr/local/bin/node"))
                        .withAppiumJS (new File ("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument (GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile (new File (System.getProperty ("user.dir") + "/src/test/resources/Logs/MoreGustUser.log")));
        service.start (); // check the logs folder

        File app = new File(System.getProperty ("user.dir") + "/App/app-debug.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability ("platformName", "android");
        desiredCapabilities.setCapability ("deviceName", "emulator-5556");
        /*desiredCapabilities.setCapability ( "platformName", "android");
        desiredCapabilities.setCapability ( "deviceName", "Huaweip10lite");
        desiredCapabilities.setCapability (  "platformVersion", "8.0");
          */
        desiredCapabilities.setCapability ("app", app.getAbsolutePath ());
        desiredCapabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
        URL remoteUrl = new URL ("http://localhost:4723/wd/hub");
        driver = new AndroidDriver (remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Utils.sleep (10);
        screenshot(Suaad_ScreenShot+"Case3");
        if (driver.findElementById("com.android.packageinstaller:id/permission_allow_button").isDisplayed()) {
            driver.findElementById ("com.android.packageinstaller:id/permission_allow_button").click ();
        }
    }
    // Method to screen shot
    public static void screenshot(String path_screenshot) throws IOException {
        File srcFile = driver.getScreenshotAs (OutputType.FILE);
        File targetFile = new File(path_screenshot+".jpg");
        FileUtils.copyFile(srcFile, targetFile);
    }
    @After
    public void tearDown () {
        driver.quit ();
        service.stop ();
    }


    //start

    @Test
    public void MorePageWithGustUser ()  throws Exception {
        Utils.sleep (30);
        screenshot(Suaad_ScreenShot+"Case2");
        driver.findElementById ("com.hungerstation.android.web.debug:id/smallLabel").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/more_item").click ();
        Utils.sleep (4);
    }
    @Test
    public void ReturnBack ()   throws Exception {
        Utils.sleep (1);
        driver.findElementById ("com.hungerstation.android.web.debug:id/more_item").click ();
        Utils.sleep (3);
        driver.findElementByClassName ("androidx.drawerlayout.widget.DrawerLayout").click ();
        screenshot(Suaad_ScreenShot+"Case2");
        Utils.sleep (3);

    }
    @Test
    public void SettingScreen () throws IOException {
        Utils.sleep (1);
        driver.findElementById ("com.hungerstation.android.web.debug:id/more_item").click ();
        driver.findElementByClassName ("androidx.drawerlayout.widget.DrawerLayout").click ();
        screenshot(Suaad_ScreenShot+"Case4");
    }


}
