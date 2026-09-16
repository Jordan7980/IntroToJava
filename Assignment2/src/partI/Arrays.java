package partI;

public class Arrays {

	public static double[] flatten(double[][] matrix) {
		double[] flat = new double[matrix.length * matrix[0].length];

		for(int i = 0; i < matrix.length; ++i){
			for(int j = 0; j < matrix[i].length; j++){
				flat[i * matrix[i].length + j] = matrix[i][j];
			}
		}
		return flat;
	}
	
	public static double[][] rotate90(double[][] matrix) {
		

		for(int i = 0; i < matrix.length; ++i){
			for(int j = 0; i < matrix[0].length; ++j){

			}
		}

		return null;
	}
	
	public static void main(String[] args) {
		double[][] m = {
			    { 1.0,  2.0,  3.0,  4.0,  5.0,  6.0},
			    { 7.0,  8.0,  9.0, 10.0, 11.0, 12.0},
			    {13.0, 14.0, 15.0, 16.0, 17.0, 18.0},
			    {19.0, 20.0, 21.0, 22.0, 23.0, 24.0},
			    {25.0, 26.0, 27.0, 28.0, 29.0, 30.0},
			    {31.0, 32.0, 33.0, 34.0, 35.0, 36.0}
			};
		
		double[] flattened = flatten(m);
		double[][] rotated = rotate90(m);
		
		System.out.print("flattened matrix is: [");
		for(int i = 0; i < flattened.length; ++i){
			System.out.print(" " + flattened[i]);
		}
		System.out.println(']');


		System.out.println("rotated matrix is: ");
		
	}
}
