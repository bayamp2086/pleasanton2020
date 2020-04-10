package com.bayamp.pleasanton2020.utils.arrayutils.tests;

import com.bayamp.pleasanton2020.data.utils.ArrayUtilsDataProvider;
import com.bayamp.pleasanton2020.utils.ArrayUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;

public class ArrayUtilsreverseArrayTests {
    /**
     * Testing the null int Array
     */
    @Test
    public void testNullArray() {
        int[] myarray = null;
        try {
            int[] ActualResults = ArrayUtils.reverseArray(myarray);
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertEquals("Array is Empty", e.getMessage());
        }
    }
    /**
     * Testing  empty int Array
     */
    @Test
    public void testEmptyArray() {
        int[] myarray = new int[]{};
        try {
            int[] ActualResults = ArrayUtils.reverseArray(myarray);
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertEquals("Array is Empty", e.getMessage());
        }
    }
    @Test(dataProvider = "getCSVData",dataProviderClass = ArrayUtilsDataProvider.class)
    public void testIntArrayPositiveTests(String[] actArray , String[] expArray) {

        try {
           int[] ActualResults = ArrayUtils.reverseArray(convertStringArrayToIntArray(actArray));
            System.out.println(Arrays.toString(ActualResults));
            System.out.println(Arrays.toString(expArray));
            Assert.assertEquals(ActualResults,convertStringArrayToIntArray(expArray));
        } catch (Exception e) {
            e.printStackTrace();
             Assert.fail();
        }
    }
private int[] convertStringArrayToIntArray(String [] myStringarray){
        int [] intArray=new int[myStringarray.length];
        for (int i=0;i<myStringarray.length;i++){
            intArray[i]=Integer.parseInt(myStringarray[i]);
        }
    return intArray;
}

    @Test
    public void testEmptyvalueinArray() {
        int[] myarray = new int[]{2,3,5, };
        try {
            int[] ActualResults = ArrayUtils.reverseArray(myarray);
            System.out.println(Arrays.toString(ActualResults));
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertEquals("Array is Empty", e.getMessage());
        }
    }
    @Test
    public void testNegativevaluesInIntArray() {
        int[] actArray = new int[]{-2,-3,-5};
        int[] expArray=new int[]{-5,-3,-2};
       try{
            int[] ActualResults = ArrayUtils.reverseArray(actArray);
Assert.assertEquals(ActualResults,expArray);

        } catch (Exception e) {
            e.printStackTrace();
           Assert.fail();
        }
    }

}