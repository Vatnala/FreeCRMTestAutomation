package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class contactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TestUtil testUtil;
	TasksPage tasksPage;
	
	public contactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialisation();
		testUtil = new TestUtil();
		loginPage  = new LoginPage();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage =homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest(){
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	@Test(priority=2)
	public void selectContactsTest(){
		contactsPage.selectContacts("Tom Peter");
		contactsPage.selectContacts("John Thomas");
	}
	@Test(priority=3)
	public void validateCreateNewContact(){
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.","Watson","Turbo", "CG");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
