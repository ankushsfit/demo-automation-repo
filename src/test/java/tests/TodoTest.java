package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.TodoPage;

public class TodoTest extends BaseTest {

	private TodoPage todoPage;

	@BeforeMethod
	public void pageSetup() {

		todoPage = new TodoPage();

	}

	@Test(priority = 1)
	public void verifyTodoTaskCreation() {

		todoPage.todoTaskCreation("Need to perform CI/CD");
		todoPage.todoTaskCreation("Need to practice GitHub Actions");

	}

	@Test(priority = 2)
	public void verifyDashboardText() {

		Assert.assertEquals(todoPage.isDashboardTextCorrect(), "TODO");

	}

	@Test(priority = 3)
	public void verifyTotalTaskCount() {

		Assert.assertEquals(todoPage.totalTaskCount(), todoPage.totalTaskCount());

	}

}