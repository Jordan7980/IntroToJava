package generics;

public class Part {
    private final String sku;
    private final double massGrams;

    public Part(String sku, double massGrams) {
        this.sku = sku;
        this.massGrams = massGrams;
    }

    public String sku()       { return sku; }
    public double massGrams() { return massGrams; }

    @Override public String toString() {
        return String.format("%s(%.1fg)", sku, massGrams);
    }
}