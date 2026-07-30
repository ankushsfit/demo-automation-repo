package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import drivers.DriverFactory;
import utils.HighlightElement;

public class TodoPage {

	private WebDriver driver;
	private HighlightElement highlightElement;

	// Locators
	private By taskInput = By.xpath("//input[@placeholder='Add a new task']");
	private By addButton = By.xpath("//button[text()='Add']");
	private By totalTask = By.xpath("//ul[@class='todo-list']/li[@class='todo-item']");
	private By dashboardName = By.cssSelector("p.eyebrow");

	// Constructor
	public TodoPage() {

		this.driver = DriverFactory.getDriver();
		this.highlightElement = new HighlightElement(driver);
		System.out.println("TodoPage driver: " + driver + " Thread: " + Thread.currentThread().getId());

	}

	// Actions
	public void enterTaskTitle(String taskTitle) {
		WebElement taskField = driver.findElement(taskInput);

		highlightElement.highlight(taskField);
		taskField.sendKeys(taskTitle);

	}

	public void clickAdd() {

		WebElement addButtonElement = driver.findElement(addButton);
		highlightElement.highlight(addButtonElement);
		addButtonElement.click();
	}

	public int totalTaskCount() {
		List<WebElement> totalTasks = driver.findElements(totalTask);
		for (WebElement totalTask : totalTasks) {
			highlightElement.highlight(totalTask);
		}
		return totalTasks.size();
	}

	public String isDashboardTextCorrect() {
		WebElement dashBoardText = driver.findElement(dashboardName);
		highlightElement.highlight(dashBoardText);
		return dashBoardText.getText();
	}

	public void todoTaskCreation(String taskTitle) {
		enterTaskTitle(taskTitle);
		clickAdd();
	}

}
