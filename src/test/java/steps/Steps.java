package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.appline.ozon.managers.PageManager;

public class Steps {

    private PageManager app = PageManager.getPageManager();

    //star
    @Когда("^Ввод ключевого слова (.+)$")
    public void insertSearch(String str) {
        app.getStartPage().insertSearch(str);
    }

    //start
    @Тогда("^Нажатие кнопки поиск$")
    public void clickSearch() {
        app.getStartPage().click();
    }

    //result
    @Когда("^Ограничить поиск по сумме (\\d+)$")
    public void insertPrice(String str) {
        app.getResultPage().insertPrice(str);

    }

    //result
    @Когда("^Отметить поле (.+)$")
    public void highRating(String str) {
        app.getResultPage().clickOnCheckBox(str);
    }

    //result
    @Когда("^Выбрать беспроводной интерфейс (.+)$")
    public void checkWirelessInterface(String str) {
        app.getResultPage().checkWirelessInterface(str);

    }

    //result
    @Тогда("^Добавить в корзину (\\d+) четных элементов$")
    public void addToCart(int count) {
        app.getResultPage().addToCart(count);

    }

    //result
    @Тогда("^Переход в корзину$")
    public void cart() {
        app.getResultPage().clickCart();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
