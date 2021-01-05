package ece325.TestCases;

import ece325.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Assignment 5: Interfaces <br />
 * Part 1: The {@code CoffeeTest} class
 */
public class CoffeeTest {
    @Test
    public void testComparable() {
        // TODO: Assignment 5 Part 1 -- rewrite this using JUnit
        List<Coffee> coffees = new ArrayList<Coffee>();
        
        coffees.add(new Coffee(10));
        coffees.add(new Coffee(2));
        coffees.add(new Coffee(10));
        coffees.add(new Coffee(20));
        coffees.add(new Coffee(5));
        Collections.sort(coffees);

        System.out.println("Coffees in order of strength:");
        for (Coffee type : coffees) {
            System.out.println(type);
        }
    }
}
