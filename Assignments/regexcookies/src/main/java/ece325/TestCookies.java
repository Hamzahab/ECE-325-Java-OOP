/**
 * ECE 325 - Fall 2020 <br/>
 * Assignment 2: Java regular expressions <br/>
 * Test cookies using regular expressions
 * <p>
 * @author <Hamzah Abdullahi>
 * Summary: Not fully functional, but almost there in my opinion
 */
package ece325;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCookies {

    /**
     * Verify a cookie and return the verification result
     * @param cookie  The cookie string
     * @return        True for a legal cookie; false for an illegal one
     */
    public static boolean verifyCookie(String cookie) {
        boolean legal = false;
        
        String digit = "[\\d]";
        String letter =  "[a-zA-Z]";

        String letDig = letter + digit;
        String letDigHyp = letDig + "[\\-]";

        String cookie_octet = "[\\x21\\x23-\\x2B\\x2D-\\x3A\\x3C-\\x5B\\x5D-\\x7E]";
        String separators = "\\(\\)<>@,\\.,;:\\\\\"/\\[\\]\\?=\\{\\} \\t"; // /t is tab
        String token = "[^" + separators + "]+";
        String cookieName = token;
        String wkday = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun)";
        String month = "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)";
        String date1 = " \\d{2} " + month + " \\d{4}";
        String time = " \\d{2}:\\d{2}:\\d{2}";
        String rfc1123Date = wkday + ", " + date1 + " " + time +" GMT";     
        String label = letter + "([" + letDigHyp + "]*[" + letDig + "])?";
        String subdomain = "(" + label + "(\\." + label + ")*)";
        String domain = "(" + subdomain + "|" + "." + subdomain + "|" + "" + ")";
        String domainAv = "Domain=" + "(" + domain + ")";
        String pathValue = "[^;]";
        String expiresAv = "(Expires=" + rfc1123Date + ")";
        String maxAgeAv = "Max\\-Age=[1-9][\\d]?";
        String pathAv = "Path=" + pathValue;      
        String secureAv = "Secure";
        String httponlyAv = "HttpOnly";
        String cookieAv = "(" + expiresAv + "|" + maxAgeAv + "|" + domainAv + "|" +
       		pathAv + "|" + secureAv + "|" + httponlyAv + ")";
        
        //may be wrong?
        String cookieValue = String.format("\"%s*\"|%s*",cookie_octet, cookie_octet);
        String cookiePair = cookieName + "=(" + cookieValue + ")";
        String setCookieString = cookiePair + "(; " + cookieAv + ")*";
        String setCookieHeader = "^Set-Cookie: " + setCookieString + "$";

        String pattern = setCookieHeader;
        
        //compile
        Pattern p = Pattern.compile(pattern);
        //matcher 
        Matcher match = p.matcher(cookie);
        
        if (match.matches()) {
        	legal = true;
        }

        return legal;
    }

    /**
     * Main entry
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        String [] cookies = {
            // Legal cookies:
            "Set-Cookie: ns1=\"alss/0.foobar^\"",                                           // 01 name=value
            "Set-Cookie: ns1=",                                                             // 02 empty value
            "Set-Cookie: ns1=\"alss/0.foobar^\"; Expires=Tue, 18 Nov 2008 16:35:39 GMT",    // 03 Expires=time_stamp
            "Set-Cookie: ns1=; Domain=",                                                    // 04 empty domain
            "Set-Cookie: ns1=; Domain=.srv.a.com-0",                                        // 05 Domain=host_name
            "Set-Cookie: lu=Rg3v; Expires=Tue, 18 Nov 2008 16:35:39 GMT; Path=/; Domain=.example.com; HttpOnly", // 06
            // Illegal cookies:
            "Set-Cookie:",                                              // 07 empty cookie-pair
            "Set-Cookie: sd",                                           // 08 illegal cookie-pair: no "="
            "Set-Cookie: =alss/0.foobar^",                              // 09 illegal cookie-pair: empty name
            "Set-Cookie: ns@1=alss/0.foobar^",                          // 10 illegal cookie-pair: illegal name
            "Set-Cookie: ns1=alss/0.foobar^;",                          // 11 trailing ";"
            "Set-Cookie: ns1=; Expires=Tue 18 Nov 2008 16:35:39 GMT",   // 12 illegal Expires value
            "Set-Cookie: ns1=alss/0.foobar^; Max-Age=01",               // 13 illegal Max-Age: starting 0
            "Set-Cookie: ns1=alss/0.foobar^; Domain=.0com",             // 14 illegal Domain: starting 0
            "Set-Cookie: ns1=alss/0.foobar^; Domain=.com-",             // 15 illegal Domain: trailing non-letter-digit
            "Set-Cookie: ns1=alss/0.foobar^; Path=",                    // 16 illegal Path: empty
            "Set-Cookie: ns1=alss/0.foobar^; httponly",                 // 17 lower case
        };

        for (int i = 0; i < cookies.length; i++)
            System.out.println(String.format("Cookie %2d: %s", i+1, verifyCookie(cookies[i]) ? "Legal" : "Illegal"));
    }

}
