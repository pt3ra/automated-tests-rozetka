package com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchResultsPage extends BasePage {
	
	public List<WebElement> getProductTiles() {
	    return productTiles;
	}
    
    @FindBy(css = "div.goods-tile")
    private List<WebElement> productTiles;
    
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    
    public void openFirstProduct() {
        if (productTiles.isEmpty()) {
            throw new NoSuchElementException("No products found in search results");
        }
        
        WebElement firstProduct = productTiles.get(0);
        
        ((JavascriptExecutor)driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});", 
            firstProduct
        );
        
        WebElement productLink = firstProduct.findElement(By.cssSelector("span.goods-tile__title"));
        click(productLink);
    }
}