package com.aptech.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    private ServletContext context;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        context.setAttribute("rootPath", context.getContextPath());
        DatabaseSeeder.create();
        Bootstrap.load(context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DatabaseSeeder.destroy();
    }
}
