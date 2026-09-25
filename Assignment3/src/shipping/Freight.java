package shipping;

public class Freight extends Shipment{
    private int palletCount;

    Freight(String id, double lbs, int miles, double value, int pallets){
        super(id, lbs, miles, value);
        if(pallets < 1){ throw new IllegalArgumentException("Error"); }
        this.palletCount = pallets;
    }

    @Override
    protected double baseRate(){ return 95.00; }
    @Override
    protected double costPerPound(){ return 0.22; }
    @Override
    protected double costPerMile(){ return 0.18; }
    @Override
    public String serviceClass(){ return "Freight"; }
    @Override
    protected double handlingSurcharge(){ return 40.00 * palletCount; }

}
