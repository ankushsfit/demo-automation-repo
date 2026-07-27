package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TodoPage {
	
	private WebDriver driver;
 	
 	
  // Locators
    private By taskInput = By.xpath("//input[@placeholder='Add a new task']");
    private By addButton = By.xpath("//button[text()='Add']");
    private By totalTask = By.xpath("//ul[@class='todo-list']/li[@class='todo-item']");
    private By dashboardText = By.cssSelector("p.eyebrow");
    

    // Constructor
    public TodoPage(WebDriver driver) {
        this.driver = driver;
//        this.waitUtils = new WaitUtils(driver);
    }


    // Actions
    public void enterTaskTitle(String taskTitle) {
        driver.findElement(taskInput).sendKeys(taskTitle);
    }


    public void clickAdd() {
        driver.findElement(addButton).click();
    }

    
    public int totalTaskCount() {
    	List<WebElement> totalTasks = driver.findElements(totalTask);
        return totalTasks.size();
    }
    
    
    public String isDashboardTextCorrect() {;
    	return driver.findElement(dashboardText).getText();
    }
    

    public void todoTaskCreation(String taskTitle) {
        enterTaskTitle(taskTitle);
        clickAdd();
    }
	
	

}
