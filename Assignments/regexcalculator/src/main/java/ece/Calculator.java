/**
 * ECE 325 - Fall 2020 <br/>
 * Assignment 3: Exception handling <br />
 * Calculator using BNF
 * <p>
 * @author Hamzah Abdullahi
 * 
 * plan: 1. convert to infix, use regex to convert let statements into values
 *       2. convert to expression tree data structure
 *       3. calculate output
 * 
 * Plan 2: expected appooach psuedocode
 *    //did not have time to complete, please see attempted psuedocode
    /*

    for every space seperated token{
        if its an integer preceded by an operation{
            store in stack
        }
        else if its a let or equals{
            do nothing
        }
        else if its a character or an operation thats not equals{
            store its equivalent value from hash table in stack
        }
        else if its an open bracket {//this is an equal operation (ex: let a = 3){
            if theres a closed bracket
            //could either be a let statement or sub expression{
                assign variable to hash table
                remove variable and accociation from stack
                push value to stack 
            }
            recurse on everything remaining
        }
    }

        if the next token is a number{
                        take preceding character and store its equivalent in hash table
                        pop letter from stack
                        push to stack
                        return
                    }
                    else{//is a let statement equivalent to let
                        recurse on everythin to the right of the equals

 */

package ece;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    /**
     * Execute the expression, and return the correct value
     * @param exp           {@code String} The expression string
     * @return              {@code int}    The value of the expression
     */
     // Parser memory hashmap
    private HashMap<String, Integer> mem = new HashMap<>();
    private Deque<String> stringStack = new ArrayDeque<>();

    private int leftIndex = 0;
    private Pattern isInt = Pattern.compile("[\\d]");
    private Pattern isCharacter = Pattern.compile("[\\w]");

    private Pattern isLetorEquals = Pattern.compile("let|=");
    private Pattern isOperator = Pattern.compile("[\\+\\-\\*\\^]");
    private Pattern isOpenBracket = Pattern.compile("[\\(]");
    private Pattern isClosedBracket = Pattern.compile("[\\)]");
    private Pattern everythingAfterOpenBr = Pattern.compile("\\(.*");

    

    public Deque<String> execExpression(String exp) {
        int returnValue = -1;
        // TODO: Assignment 3 Part 1 -- parse, calculate the expression, and return the correct value
        
        return evaluateExpression(exp);
        // TODO: Assignment 3 Part 2-1 -- when come to illegal expressions, raise proper exceptions

        


    }

    public Deque<String> evaluateExpression(String exp){
        exp = exp.replace(";","");
        exp = exp.replaceAll("\\(", "( ");
        exp = exp.replaceAll("\\)", " )");
        
        //seperate by strings
        String[] spaceSeperated = exp.split(" ");
        boolean equalityOccuredLast = false;
        for (String t:spaceSeperated){
            //is an integer
            if (isInt.matcher(t).find()){
                stringStack.push(t);
            }
            //is a let or equals operation,do nothing
            else if(isLetorEquals.matcher(t).find()){
                equalityOccuredLast = true;
                continue;
            }
            //is a character 
            else if(isCharacter.matcher(t).find()){
                //push to stack
                stringStack.push(t);
            }
            //is an operator thats not equal
            else if (isOperator.matcher(t).find()){
                stringStack.push(t);
                equalityOccuredLast = false;
            }
            //is an open bracket
            else if(isOpenBracket.matcher(t).find()){
                //recurse
                
                evaluateExpression(exp.substring(everythingAfterOpenBr.matcher(exp).start()));
            }
            else if(isClosedBracket.matcher(t).find()){
                //pop the last two things from stack
                if(equalityOccuredLast){
                    String val = stringStack.pop();
                    String key = stringStack.pop();
                    mem.put(key,Integer.parseInt(val));
                    stringStack.push(val);
                    return stringStack;
                }
        }
    }
    return stringStack;
}
    ///psuedocode
 

    







    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        // Part 1
        String[] inputs = {
            "let x = 1;",                                                                           // 1, returns 1
            "(let x = 1) + x;",                                                                     // 2, returns 2
            "(let a = 2) + 3 * a - 5;",                                                             // 3, returns 3
            "(let x = (let y = (let z = 1))) + x + y + z;",                                         // 4, returns 4
            "1 + (let x = 1) + (let y = 2) + (1 + x) * (1 + y) - (let x = y) - (let y = 1) - x;",   // 5, returns 5
            "1 + (let a = (let b = 1) + b) + a + 1;",                                               // 6, returns 6
            "(let a = (let a = (let a = (let a = 2) + a) + a) + a) - 9;",                           // 7, returns 7
            "(let x = 2) ^ (let y = 3);",                                                           // 8, returns 8
            "(let y = 3) ^ (let x = 2);"                                                            // 9, returns 9
        };
        for (int i = 1; i < inputs.length; i++){
            // System.out.println(String.format("%d -- %-90s %d", i+1, inputs[i], calc.execExpression(inputs[i])));
            System.out.println(calc.execExpression(inputs[i]));

        }
        // Part 2
        inputs = new String[] {
                "1 + (2 * 3;",                  // 1, syntax error: ')' expected
                "(let x 5) + x;",               // 2, syntax error: '=' expected
                "(let x = 5) (let y = 6);",     // 3, syntax error: operator expected
                "(let x = 5 let y = 6);",       // 4, syntax error: ')' expected
                "(ler x = 5) ^ (let y = 6);",   // 5, runtime error: 'ler' undefined
                "(let x = 5) + y;"              // 6, runtime error: 'y' undefined
        };
        // TODO: Assignment 3 Part 2-2 -- catch and deal with your exceptions here
        // for (int i = 0; i < inputs.length; i++)
        //     System.out.println(String.format("%d -- %-30s %d", i+1, inputs[i], calc.execExpression(inputs[i])));
    }

}
