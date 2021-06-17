package com.krn.actitime.pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.krn.actitime.testbase.BaseClass;
import com.krn.actitime.testbase.ExcelLibrary;

public class TasksPage extends BaseClass {

	@FindBy(id = "container_tasks")
	WebElement tasksButton;
	@FindBy(xpath = "//div[text()='Add New']")
	WebElement addNewButton;
	@FindBy(xpath = "//div[@class='item createNewCustomer']")
	WebElement createNewCustomerButton;
	@FindBy(xpath = "//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")
	WebElement nameField;
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	WebElement descriptionField;
	@FindBy(xpath = "//div[@class='components_button_label' and text()='Create Customer']")
	WebElement createCustomerButton;
	@FindBy(xpath = "(//input[@placeholder='Start typing name ...'])[1]")
	WebElement customerSearchField;
	@FindBy(xpath = "(//div[@class='action'])[1]/../../../../../..//div[text()='Delete']")
	WebElement deleteButton;
	@FindBy(xpath = "//span[text()='Delete permanently']")
	WebElement deletePermanentlyButton;

	public void init(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToTasks() {
		tasksButton.click();
	}

	public void clickOnAddNew(WebDriver driver) {
		addNewButton.click();

	}

	public void clickOnCreateNewCustomer(WebDriver driver) {
		createNewCustomerButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(createCustomerButton));
	}

	public void sendCustomerName(WebDriver driver) {
		xlib = new ExcelLibrary();
		String custNm = xlib.fr("CreateCustomer", 1, 0);
		nameField.sendKeys(custNm);
	}

	public void sendDescription(WebDriver driver) {
		xlib = new ExcelLibrary();
		String desc = xlib.fr("CreateCustomer", 1, 1);
		descriptionField.sendKeys(desc);
	}

	public void clickOnCreateCustomer(WebDriver driver) throws InterruptedException {
		createCustomerButton.click();
		Thread.sleep(5000);
	}

	public void searchForCustomer(WebDriver driver) {
		xlib = new ExcelLibrary();
		String customerToDel = xlib.fr("DeleteCustomer", 1, 0);
		customerSearchField.sendKeys(customerToDel);
	}

	public void clickOnCustomer(WebDriver driver) {
		xlib = new ExcelLibrary();
		String customerToDel = xlib.fr("DeleteCustomer", 1, 0);
		WebElement custToDel = driver.findElement(By.xpath("(//span[text()='" + customerToDel + "'])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(custToDel));
		Actions act = new Actions(driver);
		custToDel.click();
	}

	public void clickOnSettingsButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions act = new Actions(driver);
		WebElement settingsBtn = driver.findElement(By.xpath("//div[@title='Manju']/..//div[@class='editButton']"));
		wait.until(ExpectedConditions.elementToBeClickable(settingsBtn));
		act.moveToElement(settingsBtn);
		settingsBtn.click();
	}

	public void clickOnActionsButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement actionBtn = driver
				.findElement(By.xpath("//div[@class='nameLabel' and text()='Manju']/../../..//div[@class='action']"));
		wait.until(ExpectedConditions.elementToBeClickable(actionBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", actionBtn);
	}

	public void clickOnDeleteButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
		js.executeScript("arguments[0].click();", deleteButton);
	}

	public void clickOnDeletePermanentlyButton(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.elementToBeClickable(deletePermanentlyButton));
		js.executeScript("arguments[0].click();", deletePermanentlyButton);
		Thread.sleep(5000);
	}

}
