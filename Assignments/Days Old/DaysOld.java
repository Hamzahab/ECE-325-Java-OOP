/*
 * Assignment 1: Using standard libraries <br />
 * Summary: Calculate age in days between given date
 * and current date, accounting for leap years 
 * 
 * Author: Hamzah Abdullahi
 * Class: ECE 325
*/
import java.util.*;
public class DaysOld {

    /**
     * Calculate how many days between today and the date, and them out
     * @param birthday      {@code String} The start date
     */
    public static void days(String birthday) {

        String[] seperatedString = birthday.split("-");

        // seperate MM,DD,YY into integer equivalent
        int givenYear = Integer.parseInt(seperatedString[0]);int givenMonth = Integer.parseInt(seperatedString[1]);int givenDay = Integer.parseInt(seperatedString[2]);

        // initialize calendars for current and given dates
        GregorianCalendar providedDate = new GregorianCalendar(givenYear, givenMonth, givenDay);
        GregorianCalendar today = new GregorianCalendar();
        
        
        //Preset strings based on output
        String oldDate = providedDate.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " " +
                        providedDate.get(Calendar.DAY_OF_MONTH) + " " + providedDate.get(Calendar.YEAR);

        String currentDate = today.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " " +
                        today.get(Calendar.DAY_OF_MONTH) + " " + today.get(Calendar.YEAR);
                
        // set current date/time
        today.setTime(new Date());

        // get difference in days and years
        int differenceYears = today.get(Calendar.YEAR) - providedDate.get(Calendar.YEAR);
        int differenceDays = today.get(Calendar.DAY_OF_YEAR) - providedDate.get(Calendar.DAY_OF_YEAR);

        // total days (base case aka not considering leap years
        differenceDays += (differenceYears*365);

        //checking if valid input
        if (differenceDays >= 0){
            // see if leap year exists in years, and if so, increment total days
            for (int i = 0;i < differenceYears;i++){
                // is leap year, therfore add day
                if (providedDate.isLeapYear(providedDate.get(Calendar.YEAR)+i)){
                    differenceDays++;
                }
            }
            String output = "Birthday: " + oldDate + "; " + " today: " + "-- You are " +  differenceDays + " days old.";
            System.out.println(output);
        }
        //"invalid input" output
        else{
            String alternateOutput = "Birthday: " + oldDate + ";"  + " today: " + currentDate + "-- Wrong birthday!";

            System.out.println(alternateOutput);
        }
    } 

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        days("2000-1-1");
        days("3000-1-1");           // This is a wrong birthday
        days("1997-10-4");
        // Add your birthday
    }

}
