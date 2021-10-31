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
        List<Order> orders=OrderDao.getPaidOrders();
        for(Order order:orders){
            System.out.println(order.getName());
        }
    }
}
