package ece325;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    public int compare(Person person1, Person person2){
        return person1.getAge().compareTo(person2.getAge());
    }
}