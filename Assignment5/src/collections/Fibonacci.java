	package collections;

import java.util.concurrent.ConcurrentHashMap;

public class Fibonacci {

	static long fib(int n) {
	    if (n < 2) return n;
	    return fib(n - 1) + fib(n - 2);
	}

	
	static ConcurrentHashMap<Integer, Long> cache = new ConcurrentHashMap<>();
	
	static long fibmemoized(int n) {
		
	    if (n < 2) return n;
		Long cached = cache.get(n);
		if(cached != null){ return cached; }

		long mem = fibmemoized(n - 1) + fibmemoized(n - 2);
		cache.put(n, mem);

	    return mem;
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		long result = fib(45);
		long end = System.currentTimeMillis();

		long fibTime = end - start;
		System.out.println("Result = " + result + " | fib took " + fibTime + " ms");
		
		
		start = System.currentTimeMillis();
		result = fibmemoized(45);
		end = System.currentTimeMillis();

		long memoTime = end - start;
		long diff = fibTime - memoTime;
		System.out.println("Result = " + result + " | fibmemoized took " + memoTime + " ms");
		System.out.println("fibmemoized is " + diff + " ms faster than fib");

		
	}
}
