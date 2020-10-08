package ru.appline.ozon.managers;

import ru.appline.ozon.pages.ResultPage;
import ru.appline.ozon.pages.StartPage;

public class PageManager {

    private static PageManager pageManager;
    private StartPage startPage;
    private ResultPage resultPage;

    private PageManager(){

    }

    public static PageManager getPageManager(){
        if (pageManager == null)
            pageManager = new PageManager();
        return pageManager;
    }

    public StartPage getStartPage(){
        if (startPage == null)
            startPage = new StartPage();
        return startPage;
    }

    public ResultPage getResultPage(){
        if (resultPage == null)
            resultPage = new ResultPage();
        return resultPage;
    }
}
