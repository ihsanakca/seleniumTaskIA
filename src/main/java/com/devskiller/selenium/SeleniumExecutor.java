package com.devskiller.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Set;

public class SeleniumExecutor implements Executor {

    private final WebDriver driver;

    public SeleniumExecutor(WebDriver driver) {
        this.driver = driver;
    }

    /// Page 1
    @Override
    public void SetLoginAndClickNext(String login) {
        String emailText = driver.findElement(By.xpath("//div[contains(text(),'Provide login: (test@devskiller.com)')]")).getText();
        String[] splitText = emailText.split("[(]");
        String inputEmail = splitText[1].substring(0, splitText[1].length() - 1);
        WebElement emailBox = driver.findElement(By.id("emailBox"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + inputEmail + "')", emailBox);
        WebElement nextBtn = driver.findElement(By.xpath("(//button[text()='Next'])[1]"));
        jse.executeScript("arguments[0].click();", nextBtn);

        // throw new org.apache.commons.lang3.NotImplementedException("Implement this method");
    }

    /// Page 2
    @Override
    public String OpenCodePageAndReturnCode() {

        WebElement openPageLink = driver.findElement(By.xpath("//a[text()='open page']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", openPageLink);

        String currentTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!currentTab.equals(tab)) {
                driver.switchTo().window(tab);
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#code"))));
        String code = driver.findElement(By.cssSelector("#code")).getAttribute("value");
        return code;
    }

    @Override
    public void SetCodeAndClickNext(String code) {
        String currentTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!currentTab.equals(tab)) {
                driver.switchTo().window(tab);
            }
        }
        WebElement codeBox = driver.findElement(By.id("codeBox"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].setAttribute('value', '" + code + "')", codeBox);
        WebElement btnLoginCode = driver.findElement(By.xpath("//button[@class='buttonLoginCode']"));
        jse.executeScript("arguments[0].click();", btnLoginCode);


        //  throw new org.apache.commons.lang3.NotImplementedException("Implement this method");
    }

    /// Page 3
    @Override
    public void FillMaskedPasswordAndClickLogin(String password) {
        driver.switchTo().frame(0);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement text = driver.findElement(By.cssSelector(".col-sm"));
        String elementText = (String) jse.executeScript("return arguments[0].innerText;", text);

        String[] split = elementText.split("\n");
        String[] split1 = split[2].split(":");
        String maskPassFull = split1[1];

        String[] maskPassSplit = maskPassFull.split("");

        WebElement element0 = driver.findElement(By.cssSelector("#passwd_0"));
        jse.executeScript("arguments[0].setAttribute('value', '" + maskPassSplit[1] + "')", element0);
        WebElement element1 = driver.findElement(By.cssSelector("#passwd_1"));
        jse.executeScript("arguments[0].setAttribute('value', '" + maskPassSplit[2] + "')", element1);
        WebElement element2 = driver.findElement(By.cssSelector("#passwd_2"));
        jse.executeScript("arguments[0].setAttribute('value', '" + maskPassSplit[3] + "')", element2);
        WebElement element3 = driver.findElement(By.cssSelector("#passwd_3"));
        jse.executeScript("arguments[0].setAttribute('value', '" + maskPassSplit[4] + "')", element3);
        WebElement element4 = driver.findElement(By.cssSelector("#passwd_4"));
        jse.executeScript("arguments[0].setAttribute('value', '" + maskPassSplit[5] + "')", element4);
        WebElement element5 = driver.findElement(By.cssSelector("#passwd_5"));
        jse.executeScript("arguments[0].setAttribute('value', '" + maskPassSplit[6] + "')", element5);
        WebElement element6 = driver.findElement(By.cssSelector("#passwd_6"));
        jse.executeScript("arguments[0].setAttribute('value', '" + maskPassSplit[7] + "')", element6);
        WebElement element7 = driver.findElement(By.cssSelector("#passwd_7"));
        jse.executeScript("arguments[0].setAttribute('value', '" + maskPassSplit[8] + "')", element7);
        WebElement element8 = driver.findElement(By.cssSelector("#passwd_8"));
        jse.executeScript("arguments[0].setAttribute('value', '" + maskPassSplit[9] + "')", element8);
        WebElement element9 = driver.findElement(By.cssSelector("#passwd_9"));
        jse.executeScript("arguments[0].setAttribute('value', '" + maskPassSplit[10] + "')", element9);

        WebElement logInBtn = driver.findElement(By.xpath("//button[text()='Log in']"));
        jse.executeScript("arguments[0].click();", logInBtn);


        // throw new org.apache.commons.lang3.NotImplementedException("Implement this method");
    }

    @Override
    public String GetLoggedInText() {
        WebElement element = driver.findElement(By.cssSelector("#loggedIn"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String elementText = (String) jse.executeScript("return arguments[0].innerText;", element);
        return elementText;
        // throw new org.apache.commons.lang3.NotImplementedException("Implement this method");
    }

}
