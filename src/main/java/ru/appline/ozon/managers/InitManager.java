package ru.appline.ozon.managers;

import java.util.concurrent.TimeUnit;

public class InitManager {

    public static void initFramework(){
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        DriverManager.getDriver().get("http://www.ozon.ru/");
    }

    public static void closeFramework(){
        DriverManager.quitDriver();
    }
}
