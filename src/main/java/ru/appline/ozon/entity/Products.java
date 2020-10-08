package ru.appline.ozon.entity;

import java.util.ArrayList;
import java.util.List;

public class Products {

    private static List<Product> productList;

    private Products(){

    }

    public static List<Product> getProductList(){
        if (productList == null)
            productList = new ArrayList<>();
        return productList;
    }
}
