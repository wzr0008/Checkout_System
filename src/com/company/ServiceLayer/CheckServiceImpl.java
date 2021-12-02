package com.company.ServiceLayer;

import com.company.Product.BasketDAO;
import java.util.*;
public class CheckServiceImpl implements CheckService{
    private Map<Integer, BasketDAO> map=new HashMap<>();
    @Override
    public Map<Integer, BasketDAO> getMap() {
        return map;
    }

    @Override
    public String check(Map<Integer, BasketDAO> map) {
        double total=0.0;
        Map<String,BasketDAO> bag=new HashMap<>();
        for(int key:map.keySet()){
            total+=map.get(key).getPrice()*map.get(key).getNumber();
            bag.put(map.get(key).getName(),map.get(key));
        }
        String valtotal=total+"";
        double discount=0.0;
        for(int key:map.keySet()){
            if(!map.get(key).getBundle().equals("null")&&bag.containsKey(map.get(key).getBundle())){
                int value1=bag.get(map.get(key).getBundle()).getNumber();
                int value2=bag.get(map.get(key).getName()).getNumber();
                int value=Math.min(value1,value2);
                discount+=map.get(key).getPrice()*value;
                bag.get(map.get(key).getName()).setNumber(map.get(key).getNumber()-value);
            }
        }
        total-=discount;
        double bundle=0.0;
        for(int key:map.keySet()){
            if(map.get(key).getDiscountThreshold()!=-1&&bag.get(map.get(key).getName()).getNumber()>=map.get(key).getDiscountThreshold()){
                bundle+=map.get(key).getDiscountPercent()*map.get(key).getPrice()*1.0*(bag.get(map.get(key).getName()).getNumber()-map.get(key).getDiscountThreshold())/100;

            }
        }
        total-=bundle;
        return "The total is "+valtotal+"-"+bundle+"(discount)-"+discount+"(bundle)="+total;
    }
}
