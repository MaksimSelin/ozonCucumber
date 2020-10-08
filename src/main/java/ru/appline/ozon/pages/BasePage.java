package ru.appline.ozon.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.ozon.managers.DriverManager;

public class BasePage {

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected void scrollToElement(WebElement webElement) {
        ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", webElement);

//        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
//                "window.scroll(" + (webElement.getLocation().x + 0) + ","
//                        + (webElement.getLocation().y - 100) + ");", webElement, 0, -100);
    }

    protected void waitElementChange(WebElement webElement, String str){
        wait.until(new ExpectedCondition<Object>() {

            @Override
            public Object apply(WebDriver driver) {
                return webElement.getAttribute("value").equals(str);
            }
        });
    }

    protected void waitLoadPage(){
        wait.until(
                driver -> ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return document.readyState")
                        .equals("complete"));
    }
}
