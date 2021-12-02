package com.company.ServiceLayer;

import com.company.Product.BasketDAO;

import java.util.*;

public interface CheckService {
       public Map<Integer, BasketDAO> getMap();
       public String check(Map<Integer,BasketDAO> map);

}
