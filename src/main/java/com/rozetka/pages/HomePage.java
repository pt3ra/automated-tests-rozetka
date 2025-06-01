package com.rozetka.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
    @FindBy(name = "search")
    private WebElement searchInput;
    
    @FindBy(css = "button.search-form__submit")
    private WebElement searchButton;
    
    @FindBy(css = "li.menu-categories__item:first-child")
    private WebElement firstCategory;
    
    @FindBy(css = "button.header-cart__button")
    private WebElement cartIcon;

    @FindBy(css = "button.header__button")
    private WebElement loginButton;
    
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void searchForProduct(String productName) {
    	click(searchInput);
        type(searchInput, productName);
        click(searchButton);
    }
    
    public void openFirstCategory() {
        click(firstCategory);
    }
    
    public void openCart() {
        click(cartIcon);
    }
    
    public void login() {
        click(loginButton);
    }
    
    public boolean isSearchFieldDisplayed() {
        try {
            return searchInput.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    @FindBy(css = "ul.sidebar-theme")
    private WebElement categoriesMenu;
    public boolean isCategoriesMenuDisplayed() {
        try {
            return categoriesMenu.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}