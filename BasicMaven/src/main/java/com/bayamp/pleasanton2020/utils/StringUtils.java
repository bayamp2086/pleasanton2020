package com.bayamp.pleasanton2020.utils;

public class StringUtils {

    public StringUtils() throws Exception{
        throw new Exception("I dont like you at all");
    }

    public static boolean isPalindrome(String input) throws Exception {

        if(input == null || input == "" || input == " ") {
            throw new NullPointerException("Hey buddy input cannot be null or empty.");
        }

        StringBuffer buff = new StringBuffer(input);

        String reverse = buff.reverse().toString();
        if(input.equals(reverse)){
            return true;
        }

        return false;

    }
    public static String sortCharcsInString(String str) {
        //char[] myCharArray= str.toCharArray();
        String[] myStrArray = str.split(" ");
        for (int i = 0; i < myStrArray.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (myStrArray[j].compareToIgnoreCase(myStrArray[j - 1]) > 0) {
                    String temp = myStrArray[j - 1];
                    myStrArray[j - 1] = myStrArray[j];
                    myStrArray[j] = temp;
                }
            }
        }
        String resStr = "";
        for (int i = myStrArray.length - 1; i >= 0; i--) {
            resStr = resStr + myStrArray[i] + " ";
        }
        return resStr.trim();
    }
}
