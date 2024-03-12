package com.mycompany.app;

import java.util.ArrayList;

public class App {
    
    public static String[] manipulateStrings(String str1, String str2, ArrayList<Integer> arrayList, int[] integerArray) {
        // Change characters in the first string according to numbers in the ArrayList
        StringBuilder modifiedStr1 = new StringBuilder(str1);
        for (int i = 0; i < arrayList.size(); i++) {
            int index = arrayList.get(i);
            if (index >= 0 && index < str2.length()) {
                modifiedStr1.setCharAt(i, str2.charAt(index));
            }
        }

        // Change characters in the second string according to numbers in the integer array
        StringBuilder modifiedStr2 = new StringBuilder(str2);
        for (int i = 0; i < integerArray.length; i++) {
            int index = integerArray[i];
            if (index >= 0 && index < str1.length()) {
                modifiedStr2.setCharAt(i, str1.charAt(index));
            }
        }

        // Return the modified strings as an array
        return new String[]{modifiedStr1.toString(), modifiedStr2.toString()};
    }
}