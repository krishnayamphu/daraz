package com.aptech;

import com.aptech.config.autotables.DiscountTable;
import com.aptech.config.autotables.ProductTable;
import com.aptech.dao.ProductDao;
import com.aptech.mail.MyMail;
import com.aptech.models.Discount;
import com.aptech.models.Product;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        DiscountTable table=new DiscountTable();
        table.createTable();
    }
}
