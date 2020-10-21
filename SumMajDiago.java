package reverse;
import java.util.Scanner;

public class SumMajDiago {
	
	public static double sumMajorDiagonal(double[][] m) {
		double sum = 0;
		for (int i=0; i<m.length; i++) {
			for (int j=0; j<m.length; j++) {
				if (i == j) {
					sum += m[i][j];
				}
			}
		}
		return sum;
	}
		
	
	public static void main(String[] args) {
		System.out.println("Please enter a 4-by-4 matrix row by row:");
		Scanner input = new Scanner(System.in);
		double A[][] = new double[4][4];
		
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<A.length; j++) {
				A[i][j] = input.nextDouble();
			}
		}
		System.out.println("Sum of the elements in the major diagonal is " + sumMajorDiagonal(A));
		input.close();
	}
}
