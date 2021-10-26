package com.aptech.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("rootPath", context.getContextPath());
        System.out.println(context.getContextPath());
        DatabaseSeeder.create();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DatabaseSeeder.destroy();
    }
}
