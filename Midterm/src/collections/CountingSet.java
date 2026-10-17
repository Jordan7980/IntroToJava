package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountingSet<T> extends HashSet<T> {

	private int total = 0;

	public CountingSet(){}

	@Override
	public boolean add(T e) {
		total++;
		return super.add(e);
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c) {
		for(T element : c) {
			total++;
		}
		return super.addAll(c);
	}

	public int getCount(){
		return total;
	}

	public static void main(String[] args) {
		
		Set s = new CountingSet();
		
		// assume a countingset of integers
		for (int i=0;i<1000;i++) {
			s.add(i);
		}
		
		for (int i=450;i<600;i++) {
			
			s.remove(i);
		}
		for (int i=1000;i<1500;i++) {
			s.add(i);
		}
		
		System.out.println("size of counting set is " + s.size());
		CountingSet c = (CountingSet)s;
		System.out.println("total count of countingSet is " +
				c.getCount());
		
		
	}
}
