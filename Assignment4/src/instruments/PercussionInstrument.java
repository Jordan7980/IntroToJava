package instruments;

public abstract class PercussionInstrument extends Instrument {
    private boolean pitched;

    public PercussionInstrument(String n, String m, double w, boolean pitch){
        super(n, m, w);
        this.pitched = pitch;
    }

    public String family(){
        return "Percussion";
    }

    public String produceSound(){
        return "A struck membrane";
    }
    public boolean getPitched(){
        return pitched;
    }
}
