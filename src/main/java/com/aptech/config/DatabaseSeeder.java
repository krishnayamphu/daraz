package com.aptech.config;

import com.aptech.config.autotables.*;
import com.aptech.models.Product;

public class DatabaseSeeder {
    public static void create() {
//        AdminTable.createTable();
//        AdminTable.defaultData();
//        UserTable.createTable();
//        UserTable.defaultData();

//        CategoryTable.createTable();
        InventoryTable.createTable();
        DiscountTable.createTable();
        ProductTable.createTable();

        CartTable.createTable();
        OrderStatusTable.createTable();
        OrderStatusTable.defaultData();
        OrderTable.createTable();
        OrderItemDetailsTable.createTable();
        InvoiceTable.createTable();


    }

    public static void destroy() {
//        AdminTable.dropTable();
//        UserTable.dropTable();
//        CategoryTable.dropTable();
        InventoryTable.dropTable();
        DiscountTable.dropTable();
        ProductTable.dropTable();


        CartTable.dropTable();
        OrderStatusTable.dropTable();
        OrderTable.dropTable();
        OrderItemDetailsTable.dropTable();
        InvoiceTable.dropTable();

    }
}
