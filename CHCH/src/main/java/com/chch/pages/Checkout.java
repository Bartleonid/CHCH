package com.chch.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.chch.common.WebDriverUtility;
import com.chch.items.User;

public class Checkout extends WebDriverUtility {

	WebDriver driver;
	WebElement element;
	String successPage = new String("Success Page  | Charming Charlie");
	// Interface:
	String utag = "utag.js";
	String analytics = "analytics.js";
	By couponField = By.cssSelector("#coupon_code");
	Object couponCode = "LenjaDiscount";
	By applyCouponCode = By.cssSelector("#apply");
	By continueToCheckoutButton = By.cssSelector(".action.primary.checkout");
	By emailAddress = By.cssSelector("#customer-email");
	Object inputEmailAddress = "lbartshchuk@gorillagroup.com";
	By password = By.cssSelector("#customer-password");
	Object inputPassword = "Test123123";
	By loginButton = By.cssSelector(".action.login.primary");

	By nextButton = By.cssSelector(".primary .button.action.continue.primary");
	String correctQuantity = "Please correct the quantity for some products.";
	By nextDayAirEarlyAM = By.cssSelector(".col.col-method .custom-radio [id='s_method_ups_1DM']");
	By secondDayAir = By.cssSelector(".col.col-method .custom-radio [id='s_method_ups_2DA']");
	By twoDayAir = By.cssSelector(".col.col-method .custom-radio [id='s_method_fedex_FEDEX_2_DAY']");

	By payPalBraintree = By.cssSelector(".payment-method [for='braintree_paypal']");
	By creditCard = By.cssSelector(".items .payment-method [for='braintree_cc_vault_4']");
	By continueToPaypal = By.cssSelector(".primary #braintree_paypal_continue_to");
	By proceedPayPal = By.cssSelector(".content #return_url");
	By placeOrderVisa = By.cssSelector("[class='payment-method _active'] .payment-method-content .primary .action");
	By placeOrderBraintree = By.cssSelector(".primary #braintree_paypal_place_order");

	// public static $loader = ".loader";

	// Constructor - driver initialization.
	public Checkout(WebDriver driver) {
		this.driver = driver;
	}

	public Checkout checkoutActionsDiscountPaypalBraintree(User user) throws InterruptedException {
		getScriptOnPage(driver, utag);
		getScriptOnPage(driver, analytics);
		type(this.driver, couponField, couponCode);
		click(this.driver, applyCouponCode);
		click(this.driver, continueToCheckoutButton);
		type(this.driver, emailAddress, inputEmailAddress);
		click(this.driver, emailAddress);
		click(this.driver, password);
		type(this.driver, password, inputPassword);
		click(this.driver, loginButton);
		click(this.driver, nextButton);
		// click(this.driver, twoDayAir);
		click(this.driver, nextButton);
		// click(this.driver, creditCard);
		click(this.driver, payPalBraintree);
		click(this.driver, continueToPaypal);
		click(this.driver, proceedPayPal);
		click(this.driver, placeOrderBraintree);
		// driver.findElement(searchfield).sendKeys(Keys.ENTER);

		return new Checkout(driver);
	}

	public Checkout checkoutActionsDiscountCreditCard(User user) throws InterruptedException {
		getScriptOnPage(driver, utag);
		getScriptOnPage(driver, analytics);
		type(this.driver, couponField, couponCode);
		click(this.driver, applyCouponCode);
		click(this.driver, continueToCheckoutButton);
		type(this.driver, emailAddress, inputEmailAddress);
		click(this.driver, emailAddress);
		click(this.driver, password);
		type(this.driver, password, inputPassword);
		click(this.driver, loginButton);
		click(this.driver, nextButton);
		click(this.driver, nextButton);
		click(this.driver, creditCard);
		click(this.driver, creditCard);
		click(this.driver, placeOrderVisa);
		// driver.findElement(searchfield).sendKeys(Keys.ENTER);

		return new Checkout(driver);
	}

	public void compareTitle(WebDriver driver, String expectedTitle) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(successPage));
		assertEquals(driver.getTitle().substring(0, 12), expectedTitle);
		System.out.println("actualTitle  " + driver.getTitle());
		System.out.println("expectedTitle  " + expectedTitle);

	}

}
