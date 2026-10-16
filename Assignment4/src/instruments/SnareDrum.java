package instruments;

public class SnareDrum extends PercussionInstrument implements Portable{

    private boolean snaresEngaged;

    public SnareDrum(String n, String m, double w, boolean pitched, boolean snares){
        super(n, m, w, pitched);
        this.snaresEngaged = snares;
    }

    public boolean getSnaresEngaged(){
        return snaresEngaged;
    }
}
