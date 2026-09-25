package shipping;

public class Hazardous extends Freight{
    private int hazardClass;
    private boolean placardRequired;

    Hazardous(String id, double lbs, int miles, double value,
              int pallets, int hazClass, boolean required){
        super(id, lbs, miles, value, pallets);
        if(hazClass < 1 || hazClass > 9){ throw new IllegalArgumentException("Error"); }
        this.hazardClass = hazClass;
        this.placardRequired = required;
    }

    @Override
    protected double handlingSurcharge(){
        return super.handlingSurcharge() + 175.00 + (placardRequired ? 60.00:0.00);
    }
    @Override
    public String serviceClass(){ return "Hazmat"; }
    @Override
    public String toString(){ return super.toString(); }
}
