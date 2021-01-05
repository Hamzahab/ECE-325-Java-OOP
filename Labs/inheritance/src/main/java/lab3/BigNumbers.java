package lab3;

import java.math.BigInteger;;

public class BigNumbers {
    
    public static BigInteger fnv(String s) {
        BigInteger h = new BigInteger("14695981039346656037");
        BigInteger m = new BigInteger("1099511628211");
        for (int i = 0; i < s.length(); i++) {
            int currentVal = s.charAt(i);

            Integer value = currentVal;
            BigInteger indexChar = new BigInteger(value.toString());

            // Multiply then xor
            h = (h.multiply(m)).xor(indexChar);
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(fnv("Hello"));
        System.out.println(fnv("greetins"));
        System.out.println(fnv("salutations"));

    }
}
