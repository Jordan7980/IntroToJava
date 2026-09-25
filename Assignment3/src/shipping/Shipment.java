package shipping;

public class Shipment {

    private String trackingId;
    private double weightLbs;
    private int distanceMiles;
    private double declaredValue;

    Shipment(String id, double lbs, int miles, double value){
        this.trackingId = id;
        this.weightLbs = lbs;
        this.distanceMiles = miles;
        this.declaredValue = value;
    }


//    Setters
    public void setTrackingId(String trackingId) { this.trackingId = trackingId; }
    public void setWeightLbs(double weightLbs) { this.weightLbs = weightLbs; }
    public void setDistanceMiles(int distanceMiles) { this.distanceMiles = distanceMiles; }
    public void setDeclaredValue(double declaredValue) { this.declaredValue = declaredValue; }

//    getters
    public String getTrackingId() { return trackingId; }
    public double getWeightLbs() { return weightLbs; }
    public int getDistanceMiles() { return distanceMiles;}
    public double getDeclaredValue() { return declaredValue; }

    protected double baseRate(){ return 4.50; }
    protected double costPerPound(){ return 0.65; }
    protected double costPerMile(){ return 0.02; }
    protected double handlingSurcharge(){ return 0.00; }
    public String serviceClass(){ return "Standard"; }

    public double shippingCost(){
        return baseRate() + getWeightLbs()*costPerPound() + getDistanceMiles()*costPerMile();
    }
    public double insuranceFee(){
        return getDeclaredValue() * 0.01;
    }
    public double totalCharge(){
        return shippingCost() + insuranceFee() + handlingSurcharge();
    }

    public String toString(){
        String Info = getTrackingId() + " | " + getWeightLbs() + " lb | " + getDistanceMiles() + " mi | ship $";
        String Prices = shippingCost() + " | ins $" + insuranceFee() + "| hand $" + handlingSurcharge() + "| TOTAL $" + totalCharge();
        return Info + Prices;
    }



    public static void main(){


    }
}

