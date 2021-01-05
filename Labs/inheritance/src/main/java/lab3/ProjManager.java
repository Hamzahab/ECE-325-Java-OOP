package lab3;

import java.util.Date;


public class ProjManager extends SwEngineer implements SalaryRaisable,Printable {
    private Date projDeadline;

    public ProjManager(String n, double baseS, String projN, Date projD){
        super(n,baseS,projN);
        projDeadline = projD;
    }

    public Date getProjDeadline(){
        return projDeadline;
    }
    @Override
    public double RaiseSalary() {
        // TODO Auto-generated method stub
        return 1.24*super.getBaseSalary();
    }
    @Override
    public String PrintInfo() {
        // TODO Auto-generated method stub
        String info = super.getName() + " " + super.getProjName() + 
                    " Salary:$" + super.getBaseSalary()*1.24 + " Deadline: "+
                    projDeadline;
        return info;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProjManager)) {
            return false;
        } 
        ProjManager pm = (ProjManager) obj;
        return projDeadline.equals(pm.getProjDeadline());
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash ^ (null == projDeadline ? 0 : projDeadline.hashCode());
        return hash;
    }
}
