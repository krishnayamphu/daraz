package com.aptech;

import com.aptech.config.autotables.UserTable;
import com.aptech.dao.CartDao;
import com.aptech.dao.CategoryDao;
import com.aptech.models.CartItem;
import com.aptech.models.Category;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        CategoryDao.addCategory(new Category("abc","ddd"));
    }
}
