package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import drivers.DriverFactory;

public class BaseTest {

	protected WebDriver driver;

	@Parameters("browser")
	@BeforeTest(alwaysRun = true)
	public void setup(@Optional("chrome") String browser) {

		DriverFactory.initializeDriver(browser);

		driver = DriverFactory.getDriver();

		driver.get("http://localhost:5173/");
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {

		DriverFactory.quitDriver();

	}

}