package ece325;

import java.security.PublicKey;
import java.util.Collection;
import java.util.Iterator;

/**
 * Assignment 5: Interfaces <br />
 * Part 1: The {@code Coffee} class
 */
public class Coffee implements Comparable<Coffee> {
    private int strength;       // The strength of the coffee
    // TODO: Assignment 5 Part 1 -- complete this class


    public Coffee(int cStrength){
        this.strength = cStrength;
    }


    @Override
    public int compareTo(Coffee c){
        if (this.strength < c.strength){
            return -1;
        }
        if (this.strength == c.strength){
            return 0;
        }
        return 1;
    }

    @Override
    public String toString(){
        return "Coffee Strength: " + this.strength;
    }
}
