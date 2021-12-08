package com.aptech;

import com.aptech.config.autotables.ProductTable;
import com.aptech.dao.ProductDao;
import com.aptech.mail.MyMail;
import com.aptech.models.Product;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Product> products= ProductDao.getSearchProducts("a");
        for(Product p:products)
        {
            System.out.println(p.getName());
        }
    }
}
