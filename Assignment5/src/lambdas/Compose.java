package lambdas;

import java.util.function.Function;

public class Compose {

	static <A, B, C> Function<A, C> compose(
	        Function<A, B> f,
	        Function< B, C> g) {

		
		return a -> g.apply(f.apply(a));
		
	}
	
	public static void main(String[] args) {
		
		Function<String, Integer> h = compose(
				(String s) -> s + s,
				(String s) -> s.length()
		);
		
		System.out.println("result is " + h.apply("hello"));
		
	}
}
