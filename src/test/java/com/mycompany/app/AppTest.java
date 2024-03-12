package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.TestCase;



/**
 * Unit test for simple App.
 */
public class AppTest 
extends TestCase
{
/**
 * Create the test case
 *
 * @param testName name of the test case
 */
public AppTest( String testName )
{
    super( testName );
}

public static Test suite()
{
    return new TestSuite( AppTest.class );
}

/**
 * Rigourous Test :-)
 */
public void testApp()
{
    assertTrue( true );
}
  
    public void testManipulateStrings_EmptyStrings() {
        // Test data
        String str1 = "";
        String str2 = "";
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] integerArray = {};

        // Test the method with empty strings and arrays
        String[] result = App.manipulateStrings(str1, str2, arrayList, integerArray);

        // Check if the modified strings are empty
        assertEquals("", result[0]);
        assertEquals("", result[1]);
    }
   
    public void testManipulateStrings_EmptyArrayListAndArray() {
        // Test data with empty ArrayList and array
        String str1 = "Hello";
        String str2 = "World";
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] integerArray = {};

        // Expected results
        String expectedStr1 = "Hello";
        String expectedStr2 = "World";

        // Test the method with empty ArrayList and array
        String[] result = App.manipulateStrings(str1, str2, arrayList, integerArray);

        // Check if the strings are unchanged
        assertEquals(expectedStr1, result[0]);
        assertEquals(expectedStr2, result[1]);
    }

}



