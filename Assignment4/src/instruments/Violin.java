package instruments;

public class Violin extends StringInstrument implements Tunable, Portable{
    private double currentA4Hz;

    public Violin(String n, String m, double w, int count) {
        super(n, m, w, count);

    }

    public String produceSound(){
        return "A borrowed tone from 4 strings";
    }

    public double getCurrentA4Hz() {
        return currentA4Hz;
    }

    @Override
    public String excitation() {
        return "bowed";
    }

    @Override
    public void tuneTo(double referenceHz){
        this.currentA4Hz = referenceHz;
    }
    @Override
    public boolean isInTune(){
        return Math.abs(CONCERT_A - currentA4Hz) < 0.5;
    }

}
