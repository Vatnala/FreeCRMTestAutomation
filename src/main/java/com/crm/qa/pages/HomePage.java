package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(), 'User: John Thomas')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the Page Objects
		public HomePage(){
			PageFactory.initElements(driver, this);
		}
		
  //Actions
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
		public boolean verifyUserNameLabel(){
			return userNameLabel.isDisplayed();
		}
		public ContactsPage clickOnContactsLink(){
			contactsLink.click();
			return new ContactsPage();
		}
		public DealsPage clickOnDealsLink(){
			return new DealsPage();
		}
		public TasksPage clickOnTaskssLink(){
			return new TasksPage();
		}
		public void clickOnNewContactLink(){
			Actions act = new Actions(driver);
			act.moveToElement(contactsLink).build().perform();
			newContactLink.click();
		}
	
}
