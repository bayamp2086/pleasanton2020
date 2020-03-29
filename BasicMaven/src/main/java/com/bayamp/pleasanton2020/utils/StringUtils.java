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

    //Reverse String by Words.
    /**
     * @param inputString
     * @return reversed string by words
     */
    public String reverseByWords(String inputString) {
        // String Array to hold values
        String[] words = inputString.split(" ");
        String str = " ";
        for (int i = words.length - 1; i >= 0; i--) {
            str = str + words[i] + " ";
        }
        return str;
    }
}
