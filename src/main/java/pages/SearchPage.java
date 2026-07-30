package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import drivers.DriverFactory;
import utils.HighlightElement;

public class SearchPage {

	private WebDriver driver;
	private HighlightElement highlightElement;

	// Locators
	private By searchBar = By.xpath("//input[@placeholder='Search tasks']");
	private By taskAfterSearch = By.xpath("//span[@class='todo-text']");

	// Constructor
	public SearchPage() {

		this.driver = DriverFactory.getDriver();
		this.highlightElement = new HighlightElement(driver);
		System.out.println("SearchPage driver: " + driver + " Thread: " + Thread.currentThread().getId());

	}

	// Actions
	public void enterTaskToSearch(String taskTitle) {

		WebElement searchField = driver.findElement(searchBar);

		highlightElement.highlight(searchField);

		searchField.sendKeys(taskTitle);

	}

	public String getTaskAfterSearch() {

		WebElement taskElement = driver.findElement(taskAfterSearch);

		highlightElement.highlight(taskElement);

		return taskElement.getText();

	}

}