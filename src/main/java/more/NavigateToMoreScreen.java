package more;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NavigateToMoreScreen {
    public  static AppiumDriverLocalService service;
    public  static AndroidDriver driver;

    public  static void main (String[] args) throws MalformedURLException, InterruptedException  {
        service = AppiumDriverLocalService.buildService (
                new AppiumServiceBuilder ().usingDriverExecutable(new File ("/usr/local/bin/node"))
                        .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/logs/Appium.log")));
        service.start ();


        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability (CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability ("deviceName", "Huaweip10lite");
        capabilities.setCapability ("platformVersion", "8.0");
        capabilities.setCapability ("app", "/Users/suaadbatis/Desktop/app.apk");
        capabilities.setCapability ("real_mobile", "true");
        driver = new AndroidDriver (new URL ("http://127.0.0.1:4723/wd/hub"), capabilities);





    }
}
