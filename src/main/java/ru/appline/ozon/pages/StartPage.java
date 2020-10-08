package ru.appline.ozon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'search-bar-wrapper')]")
    private WebElement searchPanel;

    public void insertSearch(String str) {
        searchPanel.findElement(By.xpath(".//input[@name='search']")).sendKeys(str);

    }

    public void click() {
        searchPanel.findElement(By.xpath(".//button")).click();
    }
}
