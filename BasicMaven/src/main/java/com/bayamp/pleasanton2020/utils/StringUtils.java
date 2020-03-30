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

    /**
     * @param str1
     * @param str2
     * @return
     * Convert String into String array using split
     * Iterate stringarray[0] through second array
     * Loop the iteration and check if the contents are same
     */
    public static boolean CheckIfTwoStringsHaveEqualContent(String str1, String str2) {
        String[] array1 = str1.split(" ");
        String[] array2 = str2.split(" ");
        String temp = " ";
        for (int i = 0; i < array1.length; i++) {
            boolean contains = false;
            for (int j = 0; j < array2.length; j++) {
                if (array1[i].equals(array2[j])) {
                    contains = true;
                }
            }
            if (!contains) {
                return false;
            }

        }
        return true;
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
