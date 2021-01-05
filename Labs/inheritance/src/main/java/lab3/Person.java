package lab3;


public class Person {
    
    private String name;

    Person(String n){
        name = n;
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        Person p = (Person) obj;
        return (name.equals(p.getName()));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash ^ name.hashCode();
        return hash;
    }
}
