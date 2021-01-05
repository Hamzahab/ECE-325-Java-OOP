package ece325;

public class Person {
    private Integer age;

    public Person(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return this.age;
    }

    public String toString() {
        return "Person age: " + this.age;
    }
}