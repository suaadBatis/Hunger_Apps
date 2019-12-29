package Services;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.MalformedURLException;

import static more.LoggeInUserToMoreScreen.service;

public class ServerRunner {


    protected void setUp () throws MalformedURLException {
        service = AppiumDriverLocalService.buildService (
                new AppiumServiceBuilder ().usingDriverExecutable(new File ("/usr/local/bin/node"))
                        .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File (System.getProperty("user.dir")+"/src/test/resources/Logs/MoreLgedinUser2020.log")));
    }


    public static void StartServer ()
    {
        service.start(); // check the logs folder
    }


    public static void StopServer ()
    {
        service.stop(); // check the logs folder
    }


}
