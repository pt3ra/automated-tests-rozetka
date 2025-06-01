package com.rozetka.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.rozetka.pages.*;

public class CartTest extends TestBase {
 
 @Test
 public void testProductAddedToCart() {
     String productName = "HP Pavilion 15";
     
     HomePage homePage = new HomePage(driver);
     homePage.searchForProduct(productName);
     
     SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
     searchResultsPage.openFirstProduct();
     
     ProductPage productPage = new ProductPage(driver);
     productPage.addToCartWithRetry();
     
     homePage.openCart();
     
     CartPage cartPage = new CartPage(driver);
     String productTitleInCart = cartPage.getProductTitleInCart();
     
     Assertions.assertTrue(productTitleInCart.contains(productName), 
             "Product in cart doesn't match added product");
 }
 
 @Test
 public void testCartTotalCalculation() {
     HomePage homePage = new HomePage(driver);
     homePage.searchForProduct("Lenovo IdeaPad 5");
     
     SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
     searchResultsPage.openFirstProduct();
     
     ProductPage productPage = new ProductPage(driver);
     productPage.addToCartWithRetry();
     
     homePage.openCart();
     
     CartPage cartPage = new CartPage(driver);
     String totalPrice = cartPage.getTotalPrice();
     
     Assertions.assertFalse(totalPrice.isEmpty(), "Total price is not displayed");
 }
}