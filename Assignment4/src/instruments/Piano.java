package instruments;

public class Piano extends StringInstrument implements Tunable {
    private int keyCount;
    private double Hz;

    public Piano(String n, String m, double w, int count, int keys) {
        super(n, m, w, count);
        this.keyCount = keys;
    }

    public String produceSound(){
        return "A struck tone from 230 strings";
    }

    public int getKeyCount() {
        return keyCount;
    }

    @Override
    public String excitation(){
        return "struck by hammers";
    }

    @Override
    public void tuneTo(double referenceHz) {
        this.Hz = referenceHz;
        System.out.println("Tuning takes 90 minutes");
    }

    @Override
    public boolean isInTune() {
        return Math.abs(CONCERT_A - Hz) < 0.5;
    }
}
