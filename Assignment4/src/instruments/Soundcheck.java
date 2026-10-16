package instruments;

public class Soundcheck {

	public static void main(String[] args) {
		
		Violin    violin  = new Violin("Violin",  "Stradivari", 1.2, 4);
        Piano     piano   = new Piano("Piano",    "Steinway", 800,230, 88);
        SnareDrum snare   = new SnareDrum("Snare", "Ludwig",12, true, false);
        Timpani   timpani = new Timpani("Timpani", "Adams", 200, true);

        Instrument[] ensemble = new Instrument[4];
        ensemble[0] = violin;
        ensemble[1] = piano;
        ensemble[2] = snare;
        ensemble[3] = timpani;

        for(int i = 0; i < ensemble.length; i++){
            if(ensemble[i] instanceof Tunable){
                System.out.println(ensemble[i].toString());
                ((Tunable) ensemble[i]).tune();
                ((Tunable) ensemble[i]).isInTune();
            }
        }

        for(int i = 0; i < ensemble.length; i++){
            if(ensemble[i] instanceof Portable) {
                System.out.println(ensemble[i].toString());
                ((Portable) ensemble[i]).caseType();
            }
        }

	}

}
