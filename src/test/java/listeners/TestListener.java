package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import drivers.DriverFactory;
import io.qameta.allure.Attachment;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

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

}
