package com.addictmobile.romannumber;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Converter {
    public Converter() {

    }

    public String convertInteger(int num) throws Exception {
        /*
        Checking condition on the num:
        - Should be between 1 and 3000
         */

        if (num < 1) {
            throw new Exception("The number should not be smaller than 1");
        }

        if (num > 3000) {
            throw new Exception("The number should not be greater than 3000");
        }

        LinkedHashMap<Integer, String> integerRomanMap = new LinkedHashMap<>();
        integerRomanMap.put(1000, "M");
        integerRomanMap.put(900, "CM");
        integerRomanMap.put(500, "D");
        integerRomanMap.put(400, "CD");
        integerRomanMap.put(100, "C");
        integerRomanMap.put(90, "XC");
        integerRomanMap.put(50, "L");
        integerRomanMap.put(40, "XL");
        integerRomanMap.put(10, "X");
        integerRomanMap.put(9, "IX");
        integerRomanMap.put(5, "V");
        integerRomanMap.put(4, "IV");
        integerRomanMap.put(1, "I");

        StringBuilder roman = new StringBuilder();

        for (Map.Entry<Integer, String> entry : integerRomanMap.entrySet()) {
            while (num >= entry.getKey()) {
                num -= entry.getKey();
                roman.append(entry.getValue());
            }
        }

        return roman.toString();
    }
}
