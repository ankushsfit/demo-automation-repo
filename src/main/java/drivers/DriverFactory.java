package drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private DriverFactory() {
	}

	public static void initializeDriver(String browser) {

		boolean isGitHubActions = "true".equalsIgnoreCase(System.getenv("GITHUB_ACTIONS"));

		WebDriver webDriver;

		switch (browser.toLowerCase()) {

		case "chrome":

			ChromeOptions options = new ChromeOptions();

			if (isGitHubActions) {

				options.addArguments("--headless=new");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1920,1080");

			}

			webDriver = new ChromeDriver(options);
			break;

		case "firefox":

			webDriver = new FirefoxDriver();
			break;

		case "edge":

			webDriver = new EdgeDriver();
			break;

		default:
			throw new IllegalArgumentException("Invalid browser : " + browser);

		}

		if (!isGitHubActions) {
			webDriver.manage().window().maximize();
		}

		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.set(webDriver);

		System.out.println("Driver initialized: " + Thread.currentThread().getId());
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {

		if (driver.get() != null) {

			driver.get().quit();
			driver.remove();

		}
	}

}