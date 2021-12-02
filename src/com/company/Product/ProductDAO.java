package com.company.Product;
public class ProductDAO {
    private long id=0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private double price=0.0;
    private String description="";
    private String name="";
    private String discountRule="null";
    private String bundle="null";


    public String getBundle() {
        return bundle;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    public String getDiscountRule() {
        return discountRule;
    }

    public void setDiscountRule() {
        if(this.discountThreshold!=-1){
            this.discountRule=this.discountPercent+"% off, after "+discountThreshold+" products";
        }
        else
            this.discountRule="null";
    }

    private int discountThreshold=-1;
    private int discountPercent=0;

    @Override
    public String toString() {
        return  id+"   "+name+"  "+price+"  "+description+"   "+discountRule;
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

    public ProductDAO(long id, double price, String description, String name) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.name = name;
    }

    public ProductDAO(){

    }
    public ProductDAO(double price) {
        this.price = price;
    }

    public ProductDAO(double price, String description) {
        this.price = price;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
