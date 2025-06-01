package com.rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
 
 @FindBy(css = "span.cart-product__title")
 private WebElement cartProductTitle;
 
 @FindBy(css = "button.modal__close")
 private WebElement closeCartPopup;
 
 @FindBy(css = "div.cart-receipt__sum-price")
 private WebElement totalPrice;
 
 public CartPage(WebDriver driver) {
     super(driver);
 }
 
 public String getProductTitleInCart() {
     return cartProductTitle.getText();
 }
 
 public void closeCartPopup() {
     click(closeCartPopup);
 }
 
 public String getTotalPrice() {
     return totalPrice.getText();
 }
}