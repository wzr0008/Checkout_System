package com.company.Product;

public class BasketDAO {
    private int id=-1;
    private int number=0;
    private double price=0.0;
    private String name="";
    private String Bundle="";
    private int discountThreshold=-1;
    private int discountPercent=0;

    public String getBundle() {
        return Bundle;
    }

    public void setBundle(String bundle) {
        Bundle = bundle;
    }

    public int getDiscountThreshold() {
        return discountThreshold;
    }

    public void setDiscountThreshold(int discountThreshold) {
        this.discountThreshold = discountThreshold;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
