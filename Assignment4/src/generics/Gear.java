package generics;

public class Gear extends Part {
	private final int teeth;
    public Gear(String sku, double massGrams, int teeth) {
        super(sku, massGrams);
        this.teeth = teeth;
    }
    public int teeth() { return teeth; }
}
