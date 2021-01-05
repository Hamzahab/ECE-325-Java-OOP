package lab3;

public class Employee extends Person{
    private double baseSalary;

    Employee(String n, double baseS){
        super(n);
        baseSalary = baseS;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwEngineer)) {
            return false;
        }
        
        Employee e = (Employee) obj;
        return (baseSalary == e.getBaseSalary());
        
    }
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        // double primitive will never be null (init to 0.0 normally)
        hash = 31 * hash ^ Double.valueOf(baseSalary).hashCode();
        return hash;
    }
}
