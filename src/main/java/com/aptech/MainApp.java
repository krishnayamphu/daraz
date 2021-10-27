package com.aptech;

import com.aptech.config.autotables.UserTable;
import com.aptech.dao.CartDao;
import com.aptech.models.CartItem;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        System.out.println(CartDao.getTotalCartItem(1));
    }
}
