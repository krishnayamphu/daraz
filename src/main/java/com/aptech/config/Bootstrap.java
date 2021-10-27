package com.aptech.config;

import com.aptech.models.Site;

import javax.servlet.ServletContext;

public class Bootstrap {
    public static void load(ServletContext context){
        Site site=new Site("Daraz");
        context.setAttribute("site",site);
    }
}
