package com.aptech;

import com.aptech.dao.CartDao;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<String> items= CartDao.getAllCartItems(1);
        for(String item: items){
            System.out.println(item);
        }
    }
}
