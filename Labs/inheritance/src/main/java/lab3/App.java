package lab3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Date d = new Date();
        double pmSalary = 3000;double projPrice = 15000;
        HwEngineer eng = new HwEngineer("Jon Snow", 3000);
        ProjManager pm = new ProjManager("Cooper Johnson", pmSalary, "System Upgrade",d);
        
        eng.RaiseSalary();
        System.out.println("PM raised Salary: " + pm.RaiseSalary());
        System.out.println("HW Engineer raised Salary: " + eng.RaiseSalary());
        //part 2
        Customer mainCustomer = new Customer("Jean Doe", projPrice);

        System.out.println(mainCustomer.PrintInfo()); 
        System.out.println(pm.PrintInfo()); 

        Collection<Integer> myColl = new ArrayList<Integer>();

        
    }
}
