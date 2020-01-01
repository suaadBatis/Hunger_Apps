package Services;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

      public static void takeScreenShot(AppiumDriver driver) throws IOException {

            try {
                String path = "./ScreenShots/";
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs (OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(path+ "hello" + ".jpg"));
                System.out.println ("Screenshot Taken");
            } catch (NullPointerException e) {
                //JOptionPane.showMessageDialog (null, " here is logic error "); you can used this option
                //System.out.println(e.getMessage ());  you can used this option
                System.out.println("The ScreenShot could not be taken\n" + e);
                e.printStackTrace();
            }
        }
    public static void screenshots(String path_screenshot, AppiumDriver driver) throws IOException {
          try{
        File srcFile = driver.getScreenshotAs (OutputType.FILE);
        File targetFile = new File(path_screenshot+".jpg");
        FileUtils.copyFile(srcFile, targetFile);
          } catch (NullPointerException e) {
              //JOptionPane.showMessageDialog (null, " here is logic error "); you can used this option
              //System.out.println(e.getMessage ());you can used this option
              System.out.println("The ScreenShot could not be taken\n" + e);
              e.printStackTrace();
          }
    }
 }

