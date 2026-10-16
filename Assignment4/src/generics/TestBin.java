package generics;

import java.util.ArrayList;

public class TestBin {

	public static double sumMass(ArrayList<? extends Part> items) {
	    double total = 0.0;
	    for (int i = 0; i < items.size(); i++) total += items.get(i).massGrams();
	    return total;
	}

	public static void main(String[] args) {
		Bolt b1 = new Bolt("B-10", 12.5);
		Bolt b2 = new Bolt("B-10", 12.5);
		Bolt b3 = new Bolt("B-14", 30.0);
		ArrayList<Bolt> boltList = new ArrayList<>();
		boltList.add(b1);
		boltList.add(b2);
		boltList.add(b3);

		Bin<Bolt> bolts = new Bin<>();
		bolts.add(b1);
		bolts.add(b2);
		bolts.add(b3);

		Gear g1 = new Gear("G-24", 85.0, 24);
		Gear g2 = new Gear("G-36", 140.0, 36);

		ArrayList<Gear> gearList = new ArrayList<>();
		gearList.add(g1);
		gearList.add(g2);

		Bin<Gear> gears = new Bin<>();
		gears.add(g1);
		gears.add(g2);

		System.out.println(bolts.totalMass());        // 55.0
		System.out.println(gears.totalMass());        // 225.0
		System.out.println(bolts.heaviest());         // B-14(30.0g)
		System.out.println(gears.heaviest().teeth()); // 36
		System.out.println(bolts.hasSku("B-14"));     // true


		System.out.println(sumMass(boltList));
		System.out.println(sumMass(gearList));


	}

}
