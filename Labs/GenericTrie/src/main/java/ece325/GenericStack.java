package ece325;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Lab 4: Generics <br />
 * The {@code GenericStack} class
 */
public class GenericStack<T> {
    private final int MAXIMUM = 500;
    private ArrayList<T> stack = new ArrayList<T>();

    private Pattern isInt = Pattern.compile("[\\d]");

    private Pattern isOperator = Pattern.compile("[\\+\\-\\*\\^\\/]");



    int topOfStack = 0;
    /**
     * Query the top element
     * @return          {@code T} the top element
     */
    public T peek() {
        if(stack.size() == 0){
            return null;
        }
        //not empty
        else{
            return stack.get(topOfStack);
        }
    }

    /**
     * Add a new element as top element
     * @param value     {@code T} the new element
     */
    public void push(T value) {
        if(stack.size() == MAXIMUM-1){
            throw new IllegalStateException("stack full");
        }
        //can push
        else{
            stack.add(topOfStack++, value);
        }
    }

    /**
     * Remove the top element
     * @return          {@code T} the removed element
     */
    public T pop() {
        // TODO: Lab 4 Part 1-3 -- GenericStack, finish the pop method
        //empty
        if(stack.size() == 0){
            throw new IllegalStateException("stack empty");
        }
        else{
            return stack.remove(--topOfStack);
        }
    }

    /**
     * Query the size of the stack
     * @return          {@code int} size of the element
     */
    public int size() {        
        return stack.size();
    }

    /**
     * Check if the stack is empty of not
     * @return          {@code boolean} {@code true} for empty; {@code false} for not
     */
    public boolean isEmpty() {        
        return stack.size() == 0;
    }

    /**
     * Calculate a postfix expression
     * @param exp       {@code String} the postfix expression
     * @return          {@code Double} the value of the expression
     */
    public static Double calcPostfixExpression(String exp) {
        // TODO: Lab 4 Part 1-6 -- GenericStack, calculate postfix expression
        /*
        Initialize the stack.
        ● Parse the expression string into an array of symbols, and feed them to the stack one by
        one.
        ● If the next symbol is an operand (numbers), then push it to the stack.
        ● If the next symbol is an operator, then there must be at least two operands already in the
        stack. Pop the two operands to do the corresponding calculation, and then re-push the
        result back to the stack.
        ● Repeat through all the symbols.
        ● Finally, we have only one element in the stack -- it is the final result. Pop and print it out.
        */

        GenericStack<String> stringStack = new GenericStack<String>();
        String[] seperated = exp.split(" ");
        // int index = 0;
        for(String s: seperated){
            if (stringStack.isInt.matcher(s).find()){
                stringStack.push(s);
            }
            else if(stringStack.isOperator.matcher(s).find()){
                double second = Double.parseDouble(stringStack.pop()); 
                double first = Double.parseDouble(stringStack.pop()); 
                double total = 0;
                switch(s){
                    case "+":{
                        total = first + second;
                        break;
                    }
                    case "-":{
                        total = first - second;

                        
                        break;
                    }
                    case "*":{
                        total = first * second;

                        break;
                    }
                    case "/":{
                        total = first/second;

                        break;
                    }
                    case "^":{
                        total = Math.pow(first,second);

                        break;
                    }
                }
                stringStack.push(Double.toString(total));
            }
        }
        double finalVal = Double.parseDouble(stringStack.pop());
        return finalVal;
    }

    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
     public static void main(String[] args) {
         String[] expressions = {
                 "4 1 +",                    // 1: = 5
                 "2 6 -",                    // 2: = -4
                 "3 3 *",                    // 3: = 9
                 "1 4 /",                    // 4: = 0.25
                 "2 3 ^",                    // 5: = 8
                 "2 1 + 4 * 8 - 3 ^ 6 -",    // 6: 58
         }; // String[] expressions = { ... };
         // GenericStack<String> exp = new GenericStack<String>();
         for (String s: expressions){
             System.out.println(s + " = " + calcPostfixExpression(s));
         }


     }

}
