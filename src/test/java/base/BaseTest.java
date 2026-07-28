package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import drivers.DriverFactory;

public class BaseTest {

	protected WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = DriverFactory.initializeDriver("chrome");

		driver.get("http://localhost:5173/");

	}

	@AfterClass
	public void tearDown() {

		DriverFactory.quitDriver();

	}

}
