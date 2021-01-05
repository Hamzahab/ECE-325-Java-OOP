package ece325;

import java.util.*;
public class Lambda {

    public static int sortByE(String a, String b){
        return a.charAt(0) == 'e'|| a.charAt(0) == 'E' ? 0:1;
    }

    public static String betterString(String a, String b, TwoStringPredicate s){
        if (s.lambdaPlaceholder(a, b))return a;
        return b;
    }
    public static void main(String[] args) {
        List<String> stringArray = Arrays.asList("whazzup","enzyme","merci","hello","emulate","howdy","elephant");
        System.out.println();
        System.out.println("unsorted: " + Arrays.asList(stringArray)+'\n');
        //by length (smallest to largest)
        stringArray.sort((a,b) -> a.length() - b.length());        
        System.out.println("sorted small to large:" + Arrays.asList(stringArray) +'\n');

        //by length (largest to smallest)
        stringArray.sort((a,b) -> b.length() - a.length()); 
        System.out.println("sorted large to small:" + Arrays.asList(stringArray)+'\n');

        //by first letter 
        stringArray.sort((a,b) -> a.charAt(0)-b.charAt(0)); 
        System.out.println("sorted by first letter:" + Arrays.asList(stringArray)+'\n');

        
        //sorting by e
        stringArray.sort((a,b) -> a.charAt(0) == 'e'|| a.charAt(0) == 'E' ? 0:1);
        System.out.println("sorted by e :" + Arrays.asList(stringArray)+'\n');

        //sorting by e (Again)
        stringArray.sort((a,b) -> Lambda.sortByE(a, b));
        System.out.println("sorted by e (again):" + Arrays.asList(stringArray)+'\n');

        
        //final problem
        String string1 = "This is the first string";
        String string2 = "This is the second stringgggg";
        
        String longer = Lambda.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
        System.out.println("Longer = " + longer+'\n');
        String first = Lambda.betterString(string1, string2, (s1, s2) -> true);
        System.out.println("First = " + first);
    }
}
