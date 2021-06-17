package com.krn.actitime.tasks;

import org.testng.annotations.Test;
import com.krn.actitime.testbase.BaseClass;

public class CreateCustomer extends BaseClass {
	@Test
	public void createCustomerTask() throws InterruptedException {
		tp.init(driver);
		tp.navigateToTasks();
		tp.clickOnAddNew(driver);
		tp.clickOnCreateNewCustomer(driver);
		tp.sendCustomerName(driver);
		tp.sendDescription(driver);
		tp.clickOnCreateCustomer(driver);

	}
}
