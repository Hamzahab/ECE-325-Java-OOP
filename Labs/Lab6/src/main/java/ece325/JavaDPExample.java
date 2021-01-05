package ece325;

import java.util.HashMap;

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Animal} interface
 */
interface Animal {
    /**
     * An animal speaks
     * @return              {@code String} animal speaks
     */
    public String speak ();
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Lion} class
 */
class Lion implements Animal {
    /**
     * The lion speaks
     * @return              {@code String} lion speaks
     */
    public String speak() {
        return "ROAR";
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Mouse} class
 */
class Mouse implements Animal {
    /**
     * The mouse speaks
     * @return              {@code String} mouse speaks
    */
    public String speak() {
        return "SQUEAK";
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Bison} class
 */
class Bison implements Animal {
    /**
     * The bison speaks
     * @return              {@code String} bison speaks
     */
    public String speak() {
        return "BELLOW";
    }
}

class Dog implements Animal {
    /**
     * The bison speaks
     * @return              {@code String} bison speaks
     */
    public String speak() {
        return "WOOF";
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code AnimalType} class
 */
class AnimalType {
    /**
     * Create and return an animal
     * @param criteria      {@code String} how is the animal like
     * @return              {@code Animal} the animal
     */
    private static HashMap<String,Animal> animals = new HashMap<String,Animal>();

    public static void setAnimal(String attribute, Animal animal){
        animals.put(attribute, animal);
    }

    public static void removeAnimal(String attribute){
        animals.remove(attribute, animals.get(attribute));
    }


    public static Animal getAnimal(String criteria) {
        try{
            return animals.get(criteria);
        }
        catch(Exception e){
            System.out.println("cant return animal");
            return null;
        }


    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code JavaDPExample} class
 */
public class JavaDPExample {
    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        AnimalType.setAnimal("small", new Mouse());
        AnimalType.setAnimal("big", new Bison());
        AnimalType.setAnimal("lazy", new Lion());

        System.out.println(AnimalType.getAnimal("small").speak()); 
        System.out.println(AnimalType.getAnimal("big").speak()); 
        System.out.println(AnimalType.getAnimal("lazy").speak()); 

        // TODO: Lab 6 Part 2-2 -- add an animal "Dog" here: criteria="loyal"; speak="woof"
        AnimalType.setAnimal("loyal", new Dog());


        AnimalType.getAnimal("loyal").speak();
        // TODO: Lab 6 Part 2-3 -- remove the "small" animal here: Mouse
        AnimalType.removeAnimal("small");

        try {
            AnimalType.getAnimal("small").speak();
        } catch (Exception e) {
            System.out.println("Cannot do action, Unknown animal...");
        }
    }
}
