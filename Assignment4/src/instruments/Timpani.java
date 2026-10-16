package instruments;

public class Timpani extends PercussionInstrument implements Tunable {

    private double currentPitchHz;

    public Timpani(String n, String m, double w, boolean pitch) {
        super(n, m, w, pitch);
    }

    public double getCurrentPitchHz() {
        return currentPitchHz;
    }

    @Override
    public String produceSound(){
        return "A tuned drum tone";
    }

    @Override
    public void tuneTo(double referenceHz) {
        this.currentPitchHz = referenceHz;
    }

    @Override
    public boolean isInTune() {
        return Math.abs(CONCERT_A - currentPitchHz) < 0.5;
    }
}
