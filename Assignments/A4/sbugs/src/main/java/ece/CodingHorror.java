import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * ECE 325 - Fall 2020
 * Assignment 4 Part 1: Static Code Analysis <br />
 * The buggy {@code CodingHorror} source code
 * -----------Bugs/Solutions ------------
 * * Bug 1: 
 * not encoding our input stream of characters 
 * (need to encode to a valid system since our program requires parsing).
 * Solution: use "UTF-8" or "Charset.defaultCharSet()" as the second argument 
 * to our inputstream
 * 
 * Bug 2:
 * Not checking to see if stream coming is null or not
 * Solution: if statement to check if valid and if not return null
 * 
 * Bug 3:
 * Checking if pointer is matching, not if data within input and 
 * the string "pool" itself match
 * Solution: instead of checking reference (using "=="), use .equals()
 * ex: input.equals("pool")
 * 
 * Bug 4:
 * replacing input characters 'o' with 'e's but cant replace when input is null
 * Solution: replace with an if statement that checks if its null, 
 * and if its not null, replace it.
 * 
 * Bug 5:
 * Not dealing with capital character cases, ex: 'E' or 'O'
 * Solution: use .toLowerCase() method to compare everything as expected


 */
public class CodingHorror {

    public static void main(String args[]) {
        // TODO: Assignment 4 Part 1 -- run FindBugs on the code

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = null;
        try {
            input = br.readLine();                  // e.g., peel
        } catch (IOException ioex) {
            System.err.println(ioex.getMessage());
        }
        input.replace('e', 'o');
        if (input == "pool") {
            System.out.println("User entered peel.");
        } else {
            System.out.println("User entered something else.");
        }
    }
}
