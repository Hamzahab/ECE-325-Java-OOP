package lab3;

public class Customer extends Person implements Printable{
    private double projPrice;

    Customer(String n, double projP){
        super(n);
        projPrice = projP;
    }

    public double getProjPrice(){
        return projPrice;
    }
    @Override
    public String PrintInfo() {
        // TODO Auto-generated method stub
        String info = super.getName() + "  Project Price: $" + projPrice;
        return info;
    }
}
