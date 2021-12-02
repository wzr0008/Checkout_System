package com.company.ServiceLayer;

import com.company.Product.ProductDAO;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServiceImpl implements Service{
    Map<Integer, ProductDAO> map=new HashMap<>();
    public static int id=1;

    @Override
    public String Bundle(String val1,String val2) {
        for(int key:map.keySet()){
            if(map.get(key).getName().equals(val1)){
                map.get(key).setBundle(val2);
                return val1+" has been bundled with "+val2;
            }
        }
        return null;
    }

    @Override
    public boolean check(int uid) {
        return map.containsKey(uid);
    }

    @Override
    public String Discount(String name) {
        for(int key:map.keySet()){
            if(map.get(key).getName().equals(name)){
                String input=JOptionPane.showInputDialog("Please input the number of products purchased before the discount:");
                map.get(key).setDiscountThreshold(Integer.parseInt(input));
                input=JOptionPane.showInputDialog("Please input the percent of the discount");
                map.get(key).setDiscountPercent(Integer.parseInt(input));
                return "The discount policy has been changed.";
            }
        }
        return "Sorry, we did not find the product in the system";

    }

    @Override
    public void showAll(){
        String[][] output=new String[map.size()+1][5];
        output[0][0]="id";
        output[0][1]="Name";
        output[0][2]="Price";
        output[0][3]="Discount";
        output[0][4]="Bundles";
        if(!map.isEmpty()) {
            int index = 1;
            System.out.println("id      Name    Price   Discount");
            for (int uid : map.keySet()) {
                System.out.println(map.get(uid).toString());
            }
        }
    }

    @Override
    public String Add(ProductDAO productDao) {
        boolean check=true;
        for(int uid:map.keySet()) {
            if (map.get(uid).getName().equals(productDao.getName())) {
                return "Sorry. This product has existed in the system";
            }
        }
        productDao.setId((long)id);
        map.put(id,productDao);
        id++;
        return "Congrats. This product has been added in the system";
    }

    @Override
    public String Remove(String name) {
        for(int uid:map.keySet()){
            if(map.get(uid).getName().equals(name)){
                map.remove(uid);
                return "This product has been deleted from the system.";
            }
        }
        return "Sorry. This product does not exist in the system.";
    }

    @Override
    public Map<Integer, ProductDAO> output() {
        return map;
    }

    @Override
    public String Modify(String name) {
        for(int key:map.keySet()){
            if(map.get(key).getName().equals(name)){
                boolean check=true;
                while(check) {
                    String input=JOptionPane.showInputDialog("Which part you want to modify?Press 1:Price /Press 2:Description");
                    int val=Integer.parseInt(input);
                    if(val==1){
                        input=JOptionPane.showInputDialog("Please input the updated price:");
                        map.get(key).setPrice(Double.parseDouble(input));
                        check=false;
                        return "The price is updated.";
                    }
                    else if(val==2){
                        input=JOptionPane.showInputDialog("Please input the updated description:");
                        map.get(key).setDescription(input);
                        check=false;
                        return "The description is updated.";
                    }
                    else{
                        System.out.print("Your input is incorrect, please re-enter the number:");
                    }
                }
            }
        }
      return "Sorry, this product is not in the system";
    }
}
