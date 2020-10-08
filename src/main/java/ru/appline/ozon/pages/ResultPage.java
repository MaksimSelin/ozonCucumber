package ru.appline.ozon.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.ozon.entity.Product;
import ru.appline.ozon.entity.Products;

import java.util.List;

public class ResultPage extends BasePage {

//    List<WebElement> workList;

//    WebElement workElement;

    @FindBy(xpath = "//a[contains(text(),'отзыв')]/../../a[contains(@class,'tile')]")
    private List<WebElement> mainInfo;

    @FindBy(xpath = "//div[contains(text(), 'Цена')]/..//p[contains(text(), 'до')]/../input")
    private WebElement inputMaxPrice;

    @FindBy(xpath = "//div[contains(text(), 'Беспроводные интерфейсы')]/..")
    private WebElement wirelessInterface;

    @FindBy(xpath = "//span[contains(text(), 'Высокий рейтинг')]/..")
    private WebElement highRating;

    @FindBy(xpath = "//div[contains(@class, 'result-container')]/div/div")
    private List<WebElement> searchResult;

    @FindBy(xpath = "//div[contains(text(),'Уточнение адреса')]/..//input")
    private WebElement window;

    @FindBy(xpath = "//span[contains(text(), 'Новинки')]/..")
    private List<WebElement> newItems;

    @FindBy(xpath = "//a[@href='/cart']")
    private WebElement cart;

//    @FindBy(xpath = "//aside/div")
//    private List<WebElement> filter;

    public void insertPrice(String str) {
//        for(WebElement webElement : filter){
//            workList = webElement.findElements(By.xpath(".//div[contains(text(), 'Цена')]"));
//            if (!workList.isEmpty()) break;
//        }
//
//        scrollToElement(workList.get(0));
//        workList.get(0).findElement(By.xpath("./..//p[contains(text(), 'до')]/../input")).click();
//        workList.get(0).findElement(By.xpath("./..//p[contains(text(), 'до')]/../input")).sendKeys(Keys.CONTROL, "a");
//        workList.get(0).findElement(By.xpath("./..//p[contains(text(), 'до')]/../input")).sendKeys(Keys.BACK_SPACE);
//        workList.get(0).findElement(By.xpath("./..//p[contains(text(), 'до')]/../input")).sendKeys(str);
//        waitElementChange(workList.get(0).findElement(By.xpath("./..//p[contains(text(), 'до')]/../input")), str);
//        workList = null;
        scrollToElement(inputMaxPrice);
        inputMaxPrice.click();
        inputMaxPrice.sendKeys(Keys.CONTROL, "a");
        inputMaxPrice.sendKeys(Keys.BACK_SPACE);
        inputMaxPrice.sendKeys(str);
        waitElementChange(inputMaxPrice, str);
    }

    public void clickOnCheckBox(String str) {
        switch (str) {
            case "высокий рейтинг":
                scrollToElement(highRating);
                highRating.click();
                break;
            default:
                Assert.fail("Поле " + str + " не найдено");
        }
    }

    public void checkWirelessInterface(String str) {
//        for (WebElement webElement : filter){
//            workList = webElement.findElements(By.xpath(".//div[contains(text(), 'Беспроводные интерфейсы')]"));
//            if (!workList.isEmpty()) break;
//        }
//
//        scrollToElement(workList.get(0));
//        workList.get(0).findElement(By.xpath("./..//span[contains(text(), 'NFC')]/..")).click();
//        workList = null;

        scrollToElement(wirelessInterface);
        if (!wirelessInterface.findElements(By.xpath(".//span[contains(text(), '" + str + "')]/..")).isEmpty()) {
            wirelessInterface.findElement(By.xpath(".//span[contains(text(), '" + str + "')]/..")).click();
            while (true) {
                if (newItems.isEmpty()) break;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new NotFoundException();
        }
    }

    public void addToCart(int count) {
        waitLoadPage();
        if (searchResult.size() >= (count * 2)) {
            for (int i = 0; i < count * 2; i++) {
                if (!(i % 2 == 0)) {
                    if (!(searchResult.get(i).findElements(By.xpath(".//div[text()='Узнать о поступлении']")).size()==0)){
                        count = count + 2;
                    }
                    else {
                        scrollToElement(searchResult.get(i));
                        searchResult.get(i).findElement(By.xpath(".//div[text()='В корзину']")).click();
                        Products.getProductList().add(new Product(mainInfo.get(i).getText(), searchResult.get(i).
                                findElement(By.xpath(".//span[contains(text(),'₽')]")).getText()));

                        if (!searchResult.get(i).findElements(By.xpath(".//div[text()='В корзину']")).isEmpty()) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            }
        }
    }

    public void clickCart() {
        scrollToElement(cart);
        cart.click();
    }
}
