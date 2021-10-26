package com.aptech.config;

import com.aptech.config.autotables.AdminTable;
import com.aptech.config.autotables.CartTable;
import com.aptech.config.autotables.UserTable;

public class DatabaseSeeder {
    public static void create() {
        AdminTable.createTable();
        AdminTable.defaultData();
        UserTable.createTable();
        UserTable.defaultData();

//        CreateCategoryTable.createTabe();
//        CreateInventoryTable.createTable();
//        CreateDiscountTable.createTable();
//        CreateProductTable.createTable();
        CartTable.createTable();
    }

    public static void destroy() {
        AdminTable.dropTable();
        UserTable.dropTable();

//        CreateProductTable.dropTable();
//        CreateCategoryTable.dropTable();
//        CreateInventoryTable.dropTable();
//        CreateDiscountTable.dropTable();
        CartTable.dropTable();
    }
}
