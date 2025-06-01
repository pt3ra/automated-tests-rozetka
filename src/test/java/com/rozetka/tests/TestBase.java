package com.rozetka.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

// Parent class for shared tests functionality
public class TestBase {
	protected WebDriver driver;
    
	@BeforeEach
    public void setUp() {
		// Setting up FirefoxDriver
		WebDriverManager.firefoxdriver().setup();
		
		// Initializing FirefoxDriver
        driver = new FirefoxDriver();
        
        // Common configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://rozetka.com.ua/");
    }
    
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public void waitForCartToUpdate() {
        int attempts = 0;
        while (attempts < 5) {
            if (!driver.findElements(By.cssSelector("rz-cart-product")).isEmpty() || 
                !driver.findElement(By.cssSelector("span.badge")).getText().equals("0")) {
                return;
            }
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
            attempts++;
        }
    }
}