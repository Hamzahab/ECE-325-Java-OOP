package ece325.TestCases;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ece325.*;

/**
 * JUnit test class for solving square roots
 */

public class SquareRootTests {

    // TODO: Assignment 4 Part 2 -- Checkpoint4
    private double epsilon = 0.0000001;
    private Calculator c;

    @Before 
    public void setUp() throws Exception {
    }

    @After 
    public void tearDown() throws Exception {
    }

    @Test 
    public void testRandomPositiveSquareRoot() {
        // You cannot use the Math.sqrt() function in the test!
    	Double a = (Math.random() - 0.5) * 200000000;
    	while (a < epsilon) {
            a = (Math.random() - 0.5) * 200000000;
        }    	
    	assertEquals(Calculator.squareRoot(a*a), Double.valueOf(a));
    }

    @Test 
    public void testRandomNegativeSquareRoot() {
        //
        Double a = (Math.random() - 0.5) * 200000000;
    	while (a < epsilon) {
            a = (Math.random() - 0.5) * 200000000;
        }    	
    	assertEquals(Calculator.squareRoot(a*a), Double.valueOf(a));
        
    }

    @Test 
    public void testSquareRootofZero() {
        // You cannot use the Math.sqrt() function in the test!
        double zero = 0.0;
        assertEquals(Calculator.squareRoot(zero), Double.valueOf(0.0d));

    }

    @Test 
    public void testSquareRootofOne() {
        // You cannot use the Math.sqrt() function in the test!
        double one = 1.0;
        assertEquals(Calculator.squareRoot(one), Double.valueOf(1.0d));
    }

}
