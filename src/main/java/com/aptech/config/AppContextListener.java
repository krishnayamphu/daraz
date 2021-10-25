package com.aptech.config;

import com.aptech.config.autotables.CreateAdminTable;
import com.aptech.config.autotables.CreateCartTable;
import com.aptech.config.autotables.CreateUserTable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        CreateAdminTable.createTable();
        CreateAdminTable.defaultData();
        CreateUserTable.createTable();
        CreateUserTable.defaultData();

//        CreateCategoryTable.createTabe();
//        CreateInventoryTable.createTable();
//        CreateDiscountTable.createTable();
//        CreateProductTable.createTable();
        CreateCartTable.createTable();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        CreateAdminTable.dropTable();
        CreateUserTable.dropTable();

//        CreateProductTable.dropTable();
//        CreateCategoryTable.dropTable();
//        CreateInventoryTable.dropTable();
//        CreateDiscountTable.dropTable();
        CreateCartTable.dropTable();
    }
}
