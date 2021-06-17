package com.krn.actitime.tasks;

import org.testng.annotations.Test;
import com.krn.actitime.testbase.BaseClass;

public class DeleteCustomer extends BaseClass {
	@Test
	public void deleteCustomerTask() throws InterruptedException {
		tp.init(driver);
		tp.navigateToTasks();
		tp.searchForCustomer(driver);
		tp.clickOnCustomer(driver);
		tp.clickOnSettingsButton(driver);
		tp.clickOnActionsButton(driver);
		tp.clickOnDeleteButton(driver);
		tp.clickOnDeletePermanentlyButton(driver);
	}
}
