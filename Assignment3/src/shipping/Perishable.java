package shipping;

public class Perishable extends Package{
    private int requiredTempF;
    private int transitHours;

    Perishable(String id, double lbs, int miles, double value,
               int l, int w, int h, int temp, int hrs){
        super(id, lbs, miles, value, l, w, h);
        this.requiredTempF = temp;
        this.transitHours = hrs;
    }

    @Override
    protected double handlingSurcharge(){
        return super.handlingSurcharge() + 0.75*transitHours + (requiredTempF < 32 ? 15.00:0.00);
    }
    @Override
    public String serviceClass(){ return "Cold Chain"; }
    @Override
    public String toString(){ return super.toString(); }

}
