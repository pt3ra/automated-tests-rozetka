package com.rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
 
 @FindBy(css = "h1.title__font")
 private WebElement productTitle;
 
 @FindBy(css = "button.buy-button")
 private WebElement buyButton;
 
 @FindBy(css = "span.badge")
 private WebElement cartCounter;
 
 public ProductPage(WebDriver driver) {
     super(driver);
 }
 
 public String getProductTitle() {
     return productTitle.getText();
 }
 
 public void addToCart() {
     click(buyButton);
 }
 
 public void addToCartWithRetry() {
	    int attempts = 0;
	    while (attempts < 3) {
	    	addToCart();
	        
	        try {
	        	Thread.sleep(10000);
	            if (isCartCounterUpdated()) {
	                return;
	            }
	        } catch (Exception e) {
	        }
	        
	        attempts++;
	        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
	    }
	    throw new RuntimeException("Failed to add product to cart after 3 attempts");
	}

	private boolean isCartCounterUpdated() {
	    if(Integer.valueOf(cartCounter.getText()) > 0)
	    	return true;
	    return false;
	}
 
 public String getCartCounterText() {
     return cartCounter.getText();
 }
}