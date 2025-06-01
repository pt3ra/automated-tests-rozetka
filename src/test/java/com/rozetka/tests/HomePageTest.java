package com.rozetka.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.rozetka.pages.HomePage;

public class HomePageTest extends TestBase {
 
 @Test
 public void testHomePageTitle() {
     String expectedTitle = "Інтернет-магазин ROZETKA™: офіційний сайт онлайн-гіпермаркету Розетка в Україні";
     String actualTitle = driver.getTitle();
     Assertions.assertEquals(actualTitle, expectedTitle, "Home page title doesn't match");
 }
 
 @Test
 public void testSearchFieldVisible() {
     HomePage homePage = new HomePage(driver);
     Assertions.assertTrue(homePage.isSearchFieldDisplayed(), "Search field is not visible");
 }
 
 @Test
 public void testCategoriesMenuVisible() {
     HomePage homePage = new HomePage(driver);
     Assertions.assertTrue(homePage.isCategoriesMenuDisplayed(), "Categories menu is not visible");
 }
 
}