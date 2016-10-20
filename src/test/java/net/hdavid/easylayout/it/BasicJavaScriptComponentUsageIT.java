package net.hdavid.easylayout.it;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.hdavid.easylayout.BasicJavaScriptComponentUsageUI;
import org.vaadin.addonhelpers.automated.AbstractWebDriverCase;
import org.vaadin.addonhelpers.automated.VaadinConditions;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;

/**
 * A simple example that uses Selenium to do a browser level test for a 
 * BasicJavaSCriptComponentUsageUI. For more complex tests, consider using
 * page object pattern.
 */
public class BasicJavaScriptComponentUsageIT extends AbstractWebDriverCase {

    @Test
    public void testJavaScriptComponentWithBrowser() throws InterruptedException {

        startBrowser();
        
        driver.navigate().to(
                BASEURL + BasicJavaScriptComponentUsageUI.class.getName());
        
        // Consider using Vaadin TestBench to make stuff easier
        new WebDriverWait(driver, 30).until(VaadinConditions.ajaxCallsCompleted());
        
        final WebElement inputElement = driver.findElement(By.tagName("input"));
        
        String value = inputElement.getAttribute("value");
        
        assertEquals(BasicJavaScriptComponentUsageUI.INITIAL_VALUE, value);
        
        inputElement.sendKeys("bar");

        driver.findElement(By.xpath("//button")).click();

        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        
        String notificationText = driver.findElement(By.cssSelector(".v-Notification")).getText();
        
        assertTrue(notificationText.contains("bar"));
        
        // Just for demo purposes, keep the UI open for a while
        Thread.sleep(1000);
        
        
    }
}
