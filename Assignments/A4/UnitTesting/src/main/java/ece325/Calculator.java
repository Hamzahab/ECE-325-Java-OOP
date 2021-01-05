package ece325;

import java.lang.Math;
import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Assignment 4 Part 2: Unit Testing <br />
 * The calculator to run the test cases
 */
// TODO: Assignment 4 Part 2 -- Create the Calculator here
public class Calculator{

    public Double add(double a, double b){
        return a+b;
    }

    public Double subtract(double a, double b){
        return a-b;
    }

    public Double multiply(double a, double b){
        return a*b;
    }

    public Double divide(double a, double b){
        return a/b;
    }

    public static Double squareRoot(double n) 
    { 
        return Math.pow(n, 0.5); 
    } 

    public Double[] getRoots(double a, double b, double c){
        Double[] roots = new Double[2];
		Double numerator = b*b - 4*a*c;
		if(numerator >= 0.0) {
			numerator = Calculator.squareRoot(numerator);
		
			roots[0] = (-b + numerator)/(2*a);
			roots[1] = (-b - numerator)/(2*a);
		}
		else if(numerator < 0) {
			roots[0] = Double.NaN;
			roots[1] = Double.NaN;
			return roots;
        }
        //if same roots
		if(roots[1].equals(roots[0])) {
			Double[] root = new Double[1];
			root[0] = roots[0];
			return root;
		}
		return roots;
    }   

    // public static void main(String[] args) {
    //     Calculator calc = new Calculator();
    //     double a = 1.0, b = -3.0, c = 2.0;
    //     System.out.println((Arrays.toString(calc.getRoots(a, b, c))));
    // }
}

