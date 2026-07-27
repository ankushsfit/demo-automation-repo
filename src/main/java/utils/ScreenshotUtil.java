package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static void captureScreenshot(WebDriver driver, String testName) {

		try {

			TakesScreenshot screenshot = (TakesScreenshot) driver;

			File source = screenshot.getScreenshotAs(OutputType.FILE);

			File destination = new File("screenshots/" + testName + ".png");

			FileUtils.copyFile(source, destination);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
