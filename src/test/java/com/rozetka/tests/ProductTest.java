package com.rozetka.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Assertions;
import com.rozetka.pages.HomePage;
import com.rozetka.pages.ProductPage;
import com.rozetka.pages.SearchResultsPage;

public class ProductTest extends TestBase {
 
 @Test
 public void testProductPageOpens() {
     String productName = "Galaxy S22";
     
     HomePage homePage = new HomePage(driver);
     homePage.searchForProduct(productName);
     
     SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
     assertDoesNotThrow(() -> searchResultsPage.openFirstProduct(),
             "Failed to open first product from search results");
     
     ProductPage productPage = new ProductPage(driver);
     String productTitle = productPage.getProductTitle();
     
     Assertions.assertTrue(productTitle.contains(productName), 
             "Product title doesn't contain search term: " + productName);
 }
 
 @Test
 public void testAddToCart() {
     String productName = "Xiaomi Redmi Note 11";
     
     HomePage homePage = new HomePage(driver);
     homePage.searchForProduct(productName);
     
     SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
     assertDoesNotThrow(() -> searchResultsPage.openFirstProduct(),
             "Failed to open first product from search results");
     
     ProductPage productPage = new ProductPage(driver);
     productPage.addToCart();
     
     String cartCounter = productPage.getCartCounterText();
     Assertions.assertEquals(cartCounter, "1", "Cart counter didn't update after adding product");
 }
}