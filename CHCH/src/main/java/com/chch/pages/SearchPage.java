package com.chch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chch.common.WebDriverUtility;
import com.chch.items.User;

public class SearchPage extends WebDriverUtility {

	WebDriver driver;
	WebElement element;
	// Interface:

	String utag = "utag.js";
	String analytics = "analytics.js";
	By searchIcon = By.cssSelector(".show-search.icon--search");
	By searchfield = By.cssSelector("#search");
	// Object text = "Chevron Vacay Scarf";
	Object text = "TRIMMED RAFFIA BEACH TOTE";
	By productScarf = By.cssSelector(".product-image-box>img");
	By randomProduct = By.cssSelector(".main-image-container .product-image-photo");
	By filterColor = By.cssSelector(".c-filters__content .ajax-href.c-filters__link");

	// By category = By.xpath("//*[contains(text(),'Jewelery')]");
	// By signinBtn = By.cssSelector(".sign-link>a");
	// By email = By.cssSelector("#email-field");
	// By password = By.cssSelector("#password-field");
	// By signSubmit = By.cssSelector("#sign-submit");

	// Constructor - driver initialization.
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public SearchPage SearchProduct(User user) throws InterruptedException {

		getScriptOnPage(driver, utag);
		getScriptOnPage(driver, analytics);
		click(driver, filterColor);
		selectRandomItems(driver, randomProduct);
		// click(this.driver, searchIcon);
		// click(this.driver, searchfield);
		// type(this.driver, searchfield, text);
		// click(this.driver, productScarf);

		// driver.findElement(searchfield).sendKeys(Keys.ENTER);

		// click(this.driver, signinBtn);
		// type(this.driver, email, user.email);
		// type(this.driver, password, user.password);
		// click(this.driver, signSubmit);

		return new SearchPage(driver);
	}

}
