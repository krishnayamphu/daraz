package com.aptech;

import com.aptech.config.autotables.UserTable;
import com.aptech.dao.CartDao;
import com.aptech.dao.CategoryDao;
import com.aptech.dao.OrderDao;
import com.aptech.models.CartItem;
import com.aptech.models.Category;
import com.aptech.models.Order;
import com.aptech.models.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Order order=OrderDao.getOrderItemById(6);

        System.out.println(order.getName());
        System.out.println(order.getMobile());
        System.out.println("====================");
        for (OrderItem item:order.getAllOrderItemsByOrderId(6)){
            System.out.println(item.getProductId());
            System.out.println(item.getPrice());
            System.out.println(item.getQty());
            System.out.println("=========================");

        }
    }
}
