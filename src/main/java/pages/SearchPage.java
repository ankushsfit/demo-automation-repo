package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.HighlightElement;

public class SearchPage {

	private WebDriver driver;
	private HighlightElement highlightElement;

	By searchBar = By.xpath("//input[@placeholder='Search tasks']");
	By taskAfterSearch = By.xpath("//span[@class='todo-text']");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		this.highlightElement = new HighlightElement(this.driver);
	}

	public void enterTaskToSearch(String taskTitle) {
		WebElement taskTitleEle = driver.findElement(searchBar);
		highlightElement.highlight(taskTitleEle);
		taskTitleEle.sendKeys(taskTitle);
	}

	public String tasksAfterSearch() {
		WebElement taskAfterSearchElement = driver.findElement(taskAfterSearch);
		highlightElement.highlight(taskAfterSearchElement);
		return taskAfterSearchElement.getText();
	}

}
