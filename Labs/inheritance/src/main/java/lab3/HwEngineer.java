package lab3;

public class HwEngineer extends Employee implements SalaryRaisable {
    
    HwEngineer(String n, double baseS){
        super(n, baseS);
    }
    @Override
    public double RaiseSalary() {
        // TODO Auto-generated method stub
        return 1.18*super.getBaseSalary();
    }
}
