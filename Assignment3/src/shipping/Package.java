package shipping;

public class Package extends Shipment{
    private int lengthIn;
    private int widthIn;
    private int heightIn;

    Package(String id, double lbs, int miles, double value, int l, int w, int h){
        super(id, lbs, miles, value);
        this.lengthIn = l;
        this.widthIn = w;
        this.heightIn = h;
    }

    @Override
    protected double baseRate(){ return 6.00; }
    @Override
    protected double costPerPound(){ return 0.80; }
    @Override
    public String serviceClass(){ return "Parcel"; }
    @Override
    protected double handlingSurcharge(){
        double girth = 2 * (widthIn + heightIn);
        if(lengthIn+girth > 84){ return 12.00; }
        else{ return 0.00; }
    }
}
