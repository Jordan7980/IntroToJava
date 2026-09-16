public class ApproximateEX {


    public static int approximateEX(double x, int maxN) {
        int sum = 0;
        for(int n = 0; n < maxN; n++) {
            int temp = 1;
            for (int i = 1; i <= n; ++i) {
                temp *= i;
            }
            sum += (int) Math.pow(x, n) / temp;
        }

        return sum;
    }
	
	public static void main(String[] args) {
        int num = approximateEX(10.0, 32);
        System.out.println("Approximate: " + num);
	}
}