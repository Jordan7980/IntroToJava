package shipping;

public class Envelope extends Shipment{

    Envelope(String id, double lbs, int miles, double value){
        super(id, lbs, miles, value);
    }

    @Override
    protected double baseRate(){ return 2.00; }
    @Override
    protected double costPerPound(){ return 0.00; }
    @Override
    protected double costPerMile(){ return 0.015; }
    @Override
    public String serviceClass(){ return "Letter"; }
}
