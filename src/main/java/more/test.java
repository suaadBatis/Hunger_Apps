package more;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static Services.PrintFile.PrintFiles2;


public class test {
    //private static AndroidDriver driver;
    public  AppiumDriver driver;
    private static final String Suaad_ScreenShot=("./ScreenShots/");

    @Before
    public void setUp () throws MalformedURLException {


        //StartServer(); // check the logs folder

        File app = new File(System.getProperty("user.dir") + "/App/app-debug.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability ("platformName", "android");
        desiredCapabilities.setCapability ("deviceName", "emulator-5554");
        desiredCapabilities.setCapability ("app", app.getAbsolutePath ());
        desiredCapabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
        URL remoteUrl = new URL ("http://localhost:4723/wd/hub");
        driver = new AndroidDriver (remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Utils.sleep (15);
        if (driver.findElementById("com.android.packageinstaller:id/permission_allow_button").isDisplayed()) {
            driver.findElementById ("com.android.packageinstaller:id/permission_allow_button").click ();
        }
    }



    @Test
    public  void ReturnBack () {
        Utils.sleep (1);
        driver.findElementById ("com.hungerstation.android.web.debug:id/more_item").click ();Utils.sleep (3);
        driver.findElementByClassName ("androidx.drawerlayout.widget.DrawerLayout").click ();Utils.sleep (3);
        String des = " Share your details here ex. Pass@word ";
        Utils.sleep (1);
        String path = "./PrintFilesFolder/suaad.txt";
        PrintFiles2(path, des);
        //printScreen("soso");


        }
    @After
    public void tearDown() {
        //driver.quit();
        //StopServer ();
    }


}
