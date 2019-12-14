package Services;

import more.GusetUserVisitMoreScreen;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class ScreenShot {
 public static void takeScreenShot() throws IOException {
     GusetUserVisitMoreScreen driver;
     driver = new GusetUserVisitMoreScreen();
     String path = "./ScreenShots/";
     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(scrFile, new File(path + "ScreenShots" + ".jpg"));
     System.out.println("Screenshot Taken");
 }
}
