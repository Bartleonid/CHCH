package com.chch.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.chch.common.WebDriverUtility;
import com.chch.items.CreditCard;
import com.chch.items.Items;
import com.chch.items.User;
import com.chch.pages.Checkout;
import com.chch.pages.PDP;
import com.chch.pages.SearchPage;

public class TestOrder extends WebDriverUtility {

	String successPage = new String("Success Page");
	User visitor = new User("lbartshchuk@gorillagroup.com", "Test123123");
	Items items = new Items(10);
	CreditCard creditCard = new CreditCard("4242424242424242", "01/19", "123", "TestUser", "Lenja Test",
			"United States", "Texas", "Houston", "+1 713-798-4857");

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { visitor } };
	}

	@Test(dataProvider = "getData", invocationCount = 1)
	public void PlaceOrderDiscountPaypal(User user) throws InterruptedException {
		start();
		// Initialize page
		SearchPage search = new SearchPage(driver);
		PDP pdp = new PDP(driver);
		Checkout check = new Checkout(driver);

		search.SearchProduct(user);
		pdp.selectProducts(items);
		check.checkoutActionsDiscountPaypalBraintree(user);
		check.compareTitle(driver, successPage);

		driver.quit();
	}

	@Test(dataProvider = "getData", invocationCount = 0)
	public void PlaceOrderDiscountVisa(User user) throws InterruptedException {
		start();
		// Initialize page
		SearchPage search = new SearchPage(driver);
		PDP pdp = new PDP(driver);
		Checkout check = new Checkout(driver);

		search.SearchProduct(user);
		pdp.selectProducts(items);
		check.checkoutActionsDiscountCreditCard(user);
		check.compareTitle(driver, successPage);

		driver.quit();
	}

}