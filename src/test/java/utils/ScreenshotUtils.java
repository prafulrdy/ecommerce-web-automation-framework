package utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
    public static void capture(WebDriver driver, String fileName) {
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("target/screenshots/" + fileName + ".png");
            FileUtils.copyFile(source, destination);
        } catch (IOException ignored) {
        }
    }
}
