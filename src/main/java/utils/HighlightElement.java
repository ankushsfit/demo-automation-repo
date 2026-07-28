package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement {

	public WebDriver driver;

	public HighlightElement(WebDriver driver) {
		this.driver = driver;

	}

	public void highlight(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// Add the highlight
		jse.executeScript("arguments[0].setAttribute('style', 'border: solid 5px red');", element);

		try {
			// Wait for a specified time (e.g., 500 milliseconds)
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Remove the highlight
		jse.executeScript("arguments[0].setAttribute('style', '');", element);
	}

}