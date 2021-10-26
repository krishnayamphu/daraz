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
        CartTable.createTable();
//        CreateCategoryTable.createTabe();
//        CreateInventoryTable.createTable();
//        CreateDiscountTable.createTable();
//        CreateProductTable.createTable();

    }

    public static void destroy() {
        AdminTable.dropTable();
        UserTable.dropTable();
        CartTable.dropTable();
//        CreateProductTable.dropTable();
//        CreateCategoryTable.dropTable();
//        CreateInventoryTable.dropTable();
//        CreateDiscountTable.dropTable();

    }
}
