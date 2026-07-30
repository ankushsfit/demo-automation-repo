package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPage;
import pages.TodoPage;

public class SearchTest extends BaseTest {

	private TodoPage todoPage;
	private SearchPage searchPage;

	@BeforeClass
	public void pageSetup() {

		todoPage = new TodoPage();
		searchPage = new SearchPage();

	}

//	@Test(priority = 1)
//	public void verifyTodoTaskCreation() {
//
//		todoPage.todoTaskCreation("Need to perform CI/CD");
//		todoPage.todoTaskCreation("Need to practice GitHub Actions");
//
//	}
//
//	@Test(priority = 2)
//	public void verifyDashboardText() {
//
//		Assert.assertEquals(todoPage.isDashboardTextCorrect(), "TODO");
//
//	}
//
//	@Test(priority = 3)
//	public void verifyTotalTaskCount() {
//
//		Assert.assertEquals(todoPage.totalTaskCount(), todoPage.totalTaskCount());
//
//	}

	@Test(priority = 4)
	public void verifySearchTask() {

		searchPage.enterTaskToSearch("Need to practice GitHub Actions");

	}

	@Test(priority = 5)
	public void verifyTaskAfterSearch() {
//		verifyTodoTaskCreation();
//		verifySearchTask();
		Assert.assertEquals(searchPage.getTaskAfterSearch(), "Need to practice GitHub Actions");

	}

}