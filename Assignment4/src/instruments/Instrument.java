package instruments;

public abstract class Instrument {

    private String name;
    private String make;
    private double weightLbs;

    public Instrument(String name, String make, double weight) {
        this.name = name;
        this.make = make;
        this.weightLbs = weight;
    }

    public String getName() {
        return name;
    }
    public String getMake() {
        return make;
    }
    public double weightLbs() {
        return weightLbs;
    }

    public String toString(){
        String str = getName() + " | " + getMake() + " | ";
        return str + weightLbs();
    }

    abstract public String family();
    abstract public String produceSound();

	public final String soundCheck() {
        return String.format("%-10s %-14s [%s] -> %s",
                             name, make, family(), produceSound());
    }


}
