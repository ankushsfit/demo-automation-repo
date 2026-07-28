package drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver initializeDriver(String browser) {

		boolean isGitHubActions = "true".equalsIgnoreCase(System.getenv("GITHUB_ACTIONS"));

		WebDriver webDriver;

		switch (browser.toLowerCase()) {

		case "chrome":

			ChromeOptions chromeOptions = new ChromeOptions();

			if (isGitHubActions) {

				chromeOptions.addArguments("--headless=new");

				chromeOptions.addArguments("--no-sandbox");

				chromeOptions.addArguments("--disable-dev-shm-usage");

				chromeOptions.addArguments("--disable-gpu");

				chromeOptions.addArguments("--window-size=1920,1080");

			}

			webDriver = new ChromeDriver(chromeOptions);

			break;

		case "firefox":

			webDriver = new FirefoxDriver();

			break;

		case "edge":

			webDriver = new EdgeDriver();

			break;

		default:

			throw new IllegalArgumentException("Invalid browser: " + browser);

		}

		if (!isGitHubActions) {

			webDriver.manage().window().maximize();

		}

		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.set(webDriver);

		return webDriver;

	}

	public static WebDriver getDriver() {

		return driver.get();

	}

//	public static void quitDriver() {
//
//		if (driver.get() != null) {
//
//			driver.get().quit();
//
//			driver.remove();
//
//		}
//
//	}

}
