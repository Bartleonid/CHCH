package com.chch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.chch.common.WebDriverUtility;
import com.chch.items.CreditCard;
import com.chch.items.Items;
import com.chch.items.User;

public class PDP extends WebDriverUtility {

	WebDriver driver;
	Object value = "5";
	// Interface:
	String utag = "utag.js";
	String analytics = "analytics.js";
	By colorAttribute = By.cssSelector(".swatch-attribute-options .swatch-option");
	By randomColor = By.cssSelector("[class='swatch-attribute color'] .swatch-option");
	By randomSize = By.cssSelector(".swatch-option.image");
	By addToBag = By.cssSelector("#product-addtocart-button");
	By bagIcon = By.cssSelector(".minicart-wrapper .action.showcart");
	By quantity = By.cssSelector(".control #qty");
	By quantityValue = By.cssSelector(".control #qty [value='6']");
	By filterColor = By.cssSelector(".c-filters__content .ajax-href.c-filters__link");

	// Constructor - driver initialization.
	public PDP(WebDriver driver) {
		this.driver = driver;
	}

	// Method Login:
	public PDP login(User user) throws InterruptedException {
		// click(this.driver, signinBtn);
		// type(this.driver, email, user.email);
		// type(this.driver, password, user.password);
		// click(this.driver, signSubmit);

		return new PDP(driver);
	}

	public PDP selectProducts(Items items) throws InterruptedException {

		getScriptOnPage(driver, utag);
		getScriptOnPage(driver, analytics);
		selectRandomItems(driver, randomColor);
		selectRandomItems(driver, randomSize);
		selectOptionFromDropDownList(this.driver, quantity, "4");
		click(this.driver, addToBag);
		click(this.driver, bagIcon);

		return new PDP(driver);
	}

	public PDP payByCreditCard(CreditCard crediCard) throws InterruptedException {
		// type(this.driver, creditCard, crediCard.cardNumber);
		// type(this.driver, expiration, crediCard.expiration);
		// type(this.driver, cvv, crediCard.cvv);
		// type(this.driver, nameOnCard, crediCard.nameOnCard);
		// click(this.driver, completeName);
		// type(this.driver, completeName, crediCard.completeName);
		// click(this.driver, shipAddress);
		// type(this.driver, shipAddress, crediCard.shipAddress);
		// click(this.driver, state);
		// type(this.driver, state, crediCard.state);
		// type(this.driver, shipCiity, crediCard.shipCiity);
		// type(this.driver, phone, crediCard.phone);
		// click(this.driver, completeOrder);

		return new PDP(driver);

	}
}
