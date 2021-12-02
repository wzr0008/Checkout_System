package com.company.ServiceLayer;

import com.company.Product.ProductDAO;

import java.util.*;

public interface Service {
    static int id=1;
    boolean check(int uid);
    void showAll();
    String Add(ProductDAO productDao);
    String Remove(String name);
    String Modify(String name);
    String Discount(String name);
    String Bundle(String name1,String name2);
    Map<Integer,ProductDAO> output();

}
