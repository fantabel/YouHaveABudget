package com.fantabel.yhab.model.util;

import java.util.HashMap;
import java.util.Random;

public class IdUtil {
    private static Random random = new Random();
    private static HashMap<String, Integer> counterMap = new HashMap<String, Integer>();
    
    public static Long getNextPositiveLong() {
        return Math.abs(random.nextLong());
    }
    
    public static Integer getPositiveInteger(String name) {
        Integer temp = counterMap.get(name);
        
        if (temp != null) {
            temp = new Integer(temp + 1);
        } else {
            temp = 1;
        }
        
        counterMap.put(name, temp);
        
        return temp;
    }
}
