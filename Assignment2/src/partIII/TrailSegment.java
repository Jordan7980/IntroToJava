package partIII;

public class TrailSegment {

	private final String name;
	private final double distanceMiles;
	private final int elevationGainFt;
	private final int elevationLossFt;
	private final String surface;
	private final boolean loop;

	public TrailSegment(String Name, double Distance, int Gain, int Loss, String Surface, boolean Loop){
		this.name = Name;
		this.distanceMiles = Distance;
		this.elevationGainFt = Gain;
		this.elevationLossFt = Loss;
		this.surface = Surface;
		this.loop = Loop;
	}

//
	public int netElevationChangeFt(){
		return elevationGainFt - elevationLossFt;
	}
	public double averageGradePercent(){
		return elevationGainFt / (distanceMiles * 5280.0) * 100.0;
	}
	public double difficultyScore(){
		return Math.sqrt(2 * elevationGainFt * distanceMiles);
	}
	public String difficultyClass(){
		if(difficultyScore() < 50.0){ return "easiest"; }
		else if(difficultyScore() < 100.0){ return "moderate"; }
		else if(difficultyScore() < 150.0){ return "moderately strenuous"; }
		else if(difficultyScore() < 200.0){ return "strenuous"; }
		else { return "very strenuous"; }
	}
	public double estimatedHours(){
		double mileHr = distanceMiles / 3.0;
		double ftHr = elevationGainFt / 2000.0;
		return mileHr + ftHr;
	}
	public boolean isLoop(){ return loop; }

	public String toString(){
		return name + " | " + distanceMiles  + " | " + elevationGainFt  + " | " + elevationLossFt  + " | " + surface
				+ " | " + loop;
	}

	static double totalDistance(TrailSegment[] segs){
		double total = 0.0;
		for(int i = 0; i < segs.length; ++i){
			total += segs[i].distanceMiles;
		}
		return total;
	}
	static double totalElevationGain(TrailSegment[] segs){
		double total = 0.0;
		for(int i = 0; i < segs.length; ++i){
			total += segs[i].elevationGainFt;
		}
		return total;
	}
	static double averageGrade(TrailSegment[] segs){
		double total = 0.0;
		for(int i = 0; i < segs.length; ++i){
			total += segs[i].averageGradePercent();
		}
		return total / segs.length;
	}
	static TrailSegment hardest(TrailSegment[] segs){
		double highest = 0.0;
		int idx = 0;
		for(int i = 0; i < segs.length; ++i){
			if(segs[i].difficultyScore() > highest){
				highest = segs[i].difficultyScore();
				idx = i;
			}
		}
		return segs[idx];
	}
	static TrailSegment shortest(TrailSegment[] segs){
		double dist = segs[0].distanceMiles;
		int idx = 0;
		for(int i = 1; i < segs.length; ++i){
			if(segs[i].distanceMiles < dist){
				dist = segs[i].distanceMiles;
				idx = i;
			}
		}
		return segs[idx];
	}

	public static void main(String[] args) {
		TrailSegment t1 = new TrailSegment("Old Rag Ridge", 9.4, 2510, 2510, "rock scramble", false);
		TrailSegment t2 = new TrailSegment("Cedar Run Loop", 7.2, 2200, 2200, "dirt",          true);
		TrailSegment t3 = new TrailSegment("Fox Hollow", 1.2,  310,  310, "gravel",        true);
		TrailSegment t4 = new TrailSegment("Whiteoak Canyon", 4.6, 1040, 1040, "dirt",          false);
		TrailSegment t5 = new TrailSegment("Skyline Traverse",12.5, 1980, 3240, "dirt",          false);
		TrailSegment t6 = new TrailSegment("Stony Man", 1.6,  340,  340, "gravel",        false);
		TrailSegment t7 = new TrailSegment("Riprap Hollow", 9.8, 2365, 2365, "dirt",          true);
		TrailSegment t8 = new TrailSegment("Bearfence Rock", 1.2,  275,  275, "rock scramble", true);


		TrailSegment[] trails = {t1, t2, t3, t4, t5, t6, t7, t8};

		for(int i = 0; i < trails.length; ++i){
			System.out.println(trails[i].toString());
		}
		System.out.println("================================");

		System.out.println("Total Distance: " + totalDistance(trails));
		System.out.println("Total ElevationGain: " + totalElevationGain(trails));
		System.out.println("Average Grade: " + averageGrade(trails));
		System.out.println("Hardest: " + hardest(trails).toString());
		System.out.println("Shortest: " + shortest(trails).toString());


	}

}
