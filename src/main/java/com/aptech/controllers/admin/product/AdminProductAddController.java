package com.aptech.controllers.admin.product;


import com.aptech.dao.CategoryDao;
import com.aptech.dao.ProductDao;
import com.aptech.helpers.MediaFiles;
import com.aptech.models.Category;
import com.aptech.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/product-add")
public class AdminProductAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String desc=request.getParameter("desc");
        String sku=request.getParameter("sku");
        double rg_price=Double.parseDouble(request.getParameter("rg_price"));
        double sa_price=Double.parseDouble(request.getParameter("sa_price"));
        String image=request.getParameter("image");
        int cat_id=Integer.parseInt(request.getParameter("cat_id"));



        Product product=new Product();
        product.setName(name);
        product.setDescription(desc);
        product.setSku(sku);
        product.setRegularPrice(rg_price);
        product.setSalesPrice(sa_price);
        product.setImage(image);
        product.setCategoryId(cat_id);

        if(ProductDao.addProduct(product)){
            response.sendRedirect("products");
        }else{
            String msg = "<div class='alert alert-danger'>Error while adding new product</div>";
            request.setAttribute("err", msg);
            request.getRequestDispatcher("product/signup.jsp").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = CategoryDao.getAllCategories();
        String root = getServletContext().getRealPath("/");
        File path = new File(root + "/uploads");
        if(path.exists()){
            List<File> files = MediaFiles.getMediaFiles(path);
            request.setAttribute("files",files);
        }
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("product/add.jsp").forward(request,response);
    }
}
