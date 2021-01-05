package lab3;

public class SwEngineer extends Employee{
    private String projName;

    SwEngineer(String n, double base, String projN){
        super(n,base);
        projName = projN;
    }

    public String getProjName(){
        return projName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwEngineer)) {
            return false;
        }
        
        SwEngineer sw = (SwEngineer) obj;
        return projName.equals(sw.getProjName());
        
    }
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        //todo other hash code stuff
        hash = 31 * hash ^ (null == projName ? 0 : projName.hashCode());
        return hash;
    }
}
