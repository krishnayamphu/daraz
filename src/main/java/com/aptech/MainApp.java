package com.aptech;

import com.aptech.config.autotables.ProductTable;
import com.aptech.dao.ProductDao;
import com.aptech.mail.MyMail;
import com.aptech.models.Product;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Product product= ProductDao.getProductById(1);
        for(String p:product.getCategories(1))
        {
            System.out.println(p);
        }
    }
}
