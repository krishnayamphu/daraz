package com.aptech.models;

public class CartItem {
    private int productId;
    private String name;
    private String image;
    private int qty;
    private double price;
    private double total;

    public CartItem() {
    }

    public CartItem(int productId, String name, String image, int qty, double price, double total) {
        this.productId = productId;
        this.name = name;
        this.image = image;
        this.qty = qty;
        this.price = price;
        this.total = total;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}