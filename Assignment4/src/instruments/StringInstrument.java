package instruments;

public abstract class StringInstrument extends Instrument {
    private int stringCount;

    public StringInstrument(String n, String m, double w, int count) {
        super(n, m, w);
        this.stringCount = count;
    }

    @Override
    public String family() {
        return "Strings";
    }

    public abstract String excitation();

    public int getStringCount() {
        return stringCount;
    }
}
