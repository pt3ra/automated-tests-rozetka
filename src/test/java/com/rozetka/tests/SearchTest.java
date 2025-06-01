package com.rozetka.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rozetka.pages.HomePage;
import com.rozetka.pages.SearchResultsPage;

public class SearchTest extends TestBase {
 
 @Test
 public void testSearchForProduct() {
     String productName = "Macbook Pro";
     
     HomePage homePage = new HomePage(driver);
     homePage.searchForProduct(productName);
     
     SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
     
     assertDoesNotThrow(() -> searchResultsPage.openFirstProduct(),
         "Failed to open first product from search results");
 }
 
 @Test
 public void testEmptySearch() {
     HomePage homePage = new HomePage(driver);
     homePage.searchForProduct("");
     
     SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
     
     assertTrue(searchResultsPage.getProductTiles().isEmpty(),
         "Expected empty search results but found products");
 }
}