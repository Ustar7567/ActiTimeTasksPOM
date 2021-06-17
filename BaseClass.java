package com.krn.actitime.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.krn.actitime.pageClass.TasksPage;

public class BaseClass {

	public WebDriver driver;
	public ExcelLibrary xlib;
	public TasksPage tp;

	@BeforeClass
	public void launchBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		tp = new TasksPage();
		driver.get("https://demo.actitime.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String expectedTitle = "actiTIME - Login";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle); // Add assertion checkpoints wherever needed

	}

	@AfterClass
	public void closeBrowser() {
		driver.close();

	}

	@BeforeMethod
	public void login() {
		xlib = new ExcelLibrary();
		String un = xlib.fr("Login", 1, 0);
		String pw = xlib.fr("Login", 1, 1);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		driver.findElement(By.id("loginButton")).click();

	}

	@AfterMethod
	public void logout() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		// driver.findElement(By.id("logoutLink")).click();
		WebElement logoutButton = driver.findElement(By.id("logoutLink"));
		// clicking on logout button using javascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logoutButton);

	}

}
