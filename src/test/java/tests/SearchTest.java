package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPage;
import pages.TodoPage;

public class SearchTest extends BaseTest {

	@Test(priority = 1)
	public void verifyTodoTaskCreation() {
		System.out.println("verifyTodoTaskCreation running on thread: " + Thread.currentThread().getId());
		TodoPage todoPage = new TodoPage(driver);

		todoPage.todoTaskCreation("Need to perform ci/cd");
		todoPage.todoTaskCreation("Need to practice on github actions");
	}

	@Test(priority = 2)
	public void verifyDashboardText() {
		System.out.println("verifyDashboardText running on thread: " + Thread.currentThread().getId());
		TodoPage todoPage = new TodoPage(driver);

		String dashText = todoPage.isDashboardTextCorrect();
		System.out.println("Dashboard Text: " + dashText);
		Assert.assertEquals(dashText, "TODO");
	}

	@Test(priority = 3)

	public void verifyTotalTaskCount() {
		System.out.println("verifyTotalTaskCount running on thread: " + Thread.currentThread().getId());
		TodoPage todoPage = new TodoPage(driver);

		int totalTasks = todoPage.totalTaskCount();
		System.out.println("Total Tasks: " + totalTasks);
		Assert.assertEquals(totalTasks, 2);
	}

	@Test(priority = 4)
	public void verifySearchTask() {
		System.out.println("verifySearchTask running on thread: " + Thread.currentThread().getId());
		SearchPage searchPage = new SearchPage(driver);
		searchPage.enterTaskToSearch("Need to practice on github actions");

	}

	@Test(priority = 5)
	public void verifyTaskAfterSearch() {
		System.out.println("verifyTaskAfterSearch running on thread: " + Thread.currentThread().getId());
		SearchPage searchPage = new SearchPage(driver);
		String taskAfterSearchName = searchPage.tasksAfterSearch();
		Assert.assertEquals(taskAfterSearchName, "Need to practice on github action");

	}

}
