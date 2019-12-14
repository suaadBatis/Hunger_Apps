package Services;


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


public class TestE {

    private static final String Suaad_ScreenShot=  "/Users/suaadbatis/Desktop/Suaad/";
    public  static AppiumDriverLocalService service;
    private static AndroidDriver driver;

    @Before
    public void setUp () throws IOException  {
        service = AppiumDriverLocalService.buildService (
                new AppiumServiceBuilder ().usingDriverExecutable(new File ("/usr/local/bin/node"))
                        .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File (System.getProperty("user.dir")+"/src/test/resources/Logs/More.log")));
        service.start (); // check the logs folder

        File app = new File(System.getProperty ("user.dir") + "/App/app-debug.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();

        desiredCapabilities.setCapability ("platformName", "android");
        desiredCapabilities.setCapability ("deviceName", "emulator-5556");
        desiredCapabilities.setCapability ("app", app.getAbsolutePath ());
        desiredCapabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
        URL remoteUrl = new URL ("http://localhost:4723/wd/hub");
        driver = new AndroidDriver (remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Utils.sleep (10);
        screenshot(Suaad_ScreenShot+"Case2");
        if (driver.findElementById("com.android.packageinstaller:id/permission_allow_button").isDisplayed()) {
            driver.findElementById ("com.android.packageinstaller:id/permission_allow_button").click ();
        }

    }
    public static void screenshot(String path_screenshot) throws IOException {
        File srcFile = driver.getScreenshotAs (OutputType.FILE);
        File targetFile = new File(path_screenshot+".jpg");
        FileUtils.copyFile(srcFile, targetFile);
    }

    // start testing
    @Test
    public  void ReturnBack () throws IOException {
        Utils.sleep (10);
        screenshot(Suaad_ScreenShot+"Case2");
        Utils.sleep (10);
    }

    @After
    public void tearDown() {

        driver.quit();
        service.stop ();
    }


}
