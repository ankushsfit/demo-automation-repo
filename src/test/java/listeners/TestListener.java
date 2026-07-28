package listeners;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import drivers.DriverFactory;
import io.qameta.allure.Attachment;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener, IExecutionListener {

	@Override
	public void onExecutionStart() {

		System.out.println("Cleaning old Allure results...");

		File allureResults = new File("allure-results");

		if (allureResults.exists()) {

			deleteFolder(allureResults);

			System.out.println("Old Allure results deleted");

		}

	}

	@Override
	public void onExecutionFinish() {

		System.out.println("Test execution finished");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		// Save screenshot file locally
		ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), result.getName());

		// Attach screenshot into Allure report
		attachScreenshotToAllure();

	}

	@Attachment(value = "Failed Test Screenshot", type = "image/png")
	public byte[] attachScreenshotToAllure() {

		return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);

	}

	private void deleteFolder(File folder) {

		File[] files = folder.listFiles();

		if (files != null) {

			for (File file : files) {

				if (file.isDirectory()) {

					deleteFolder(file);

				} else {

					file.delete();

				}

			}

		}

		folder.delete();

	}

}
