package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.TodoPage;

public class TodoTest extends BaseTest{
		
	
	@Test(priority=1)
	public void verifyTodoTaskCreation() {
		TodoPage todoPage = new TodoPage(driver);
		todoPage.todoTaskCreation("Need to perform ci/cd");		
		todoPage.todoTaskCreation("Need to practice on github actions");		
	}
	
	
	@Test(priority=2)
	public void verifyTotalTaskCount() {
		TodoPage todoPage = new TodoPage(driver);
		int totalTasks = todoPage.totalTaskCount();
		System.out.println("Total: "+totalTasks);
		Assert.assertEquals(totalTasks, 2);
	}
	
	@Test(priority=3)
	public void verifyDashboardText() {
		TodoPage todoPage = new TodoPage(driver);
		String dashText = todoPage.isDashboardTextCorrect();
		System.out.println("Dashboard Text: " + dashText);
		Assert.assertEquals(dashText, "TODO");
	}
	


}
