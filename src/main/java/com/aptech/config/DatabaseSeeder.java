package com.aptech.config;

import com.aptech.config.autotables.*;

public class DatabaseSeeder {
    public static void create() {
        AdminTable.createTable();
        AdminTable.defaultData();
        UserTable.createTable();
        UserTable.defaultData();
        CartTable.createTable();
        OrderStatusTable.createTable();
        OrderStatusTable.defaultData();
        OrderTable.createTable();
        OrderItemDetailsTable.createTable();
//        CreateCategoryTable.createTabe();
//        CreateInventoryTable.createTable();
//        CreateDiscountTable.createTable();
//        CreateProductTable.createTable();

    }

    public static void destroy() {
        AdminTable.dropTable();
        UserTable.dropTable();
        CartTable.dropTable();
        OrderStatusTable.dropTable();
        OrderTable.dropTable();
        OrderItemDetailsTable.dropTable();
//        CreateProductTable.dropTable();
//        CreateCategoryTable.dropTable();
//        CreateInventoryTable.dropTable();
//        CreateDiscountTable.dropTable();

    }
}
