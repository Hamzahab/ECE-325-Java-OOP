package ece325;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Assignment 5: Interfaces <br />
 * Part 3: The {@code PersonTest} class
 */
public class PersonTest {
    public static void runTest() {
        // TODO: Assignment 5 Part 3 -- rewrite this using JUnit
        Set<Person> persons = new TreeSet<Person>(new PersonComparator());
        persons.add(new Person(32));
        persons.add(new Person(17));
        persons.add(new Person(13));
        persons.add(new Person(35));
        persons.add(new Person(27));
        Integer[] orderedAges = {13, 17, 27, 32, 35};

        Integer i = 0;

        Iterator<Person> iter = persons.iterator();
        while (iter.hasNext()) {
            Person temp = iter.next();
        	assertEquals(temp.getAge(), orderedAges[i]);
            System.out.println(temp);
            i++;
    }
}
}
