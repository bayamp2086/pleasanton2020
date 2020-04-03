package com.bayamp.pleasanton2020.utils;

public class ArrayUtils {
        /*
         *
         * @param arr
         * @return
         */
        public static int[] reverseArray(int[] arr) throws Exception {
            int[] temp = new int[arr.length];
            if (arr.length== 0) throw new Exception("Array is Empty");
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[arr.length - 1 - i];}
            return temp; }
        /* second method */
        public static int[] reverseArrayParseInt(String[] arr) throws Exception {
            int[] temp = new int[arr.length];
            if (arr.length== 0) throw new Exception("Array is Empty");
            for (int i = 0; i < arr.length; i++) {
                temp[i] = Integer.parseInt(arr[arr.length - 1 - i]);}
            return temp; }
    }





