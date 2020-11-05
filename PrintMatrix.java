package reverse;
import java.util.Random;
import java.util.Scanner;

public class PrintMatrix {

	public static void printMatrix(int n) {
		
		int i = 0, j = 0;
		int A[][] = new int[n][n];
		Random r = new Random();
		
		for (i = 0; i < n; i++) {
			System.out.println();
			for (j = 0; j < n; j++) {
				A[i][j] = r.nextInt(2);
				System.out.print(A[i][j] + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.print("Please enter an integer n: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		if (n > 0) {
			printMatrix(n);
		} else {
			System.out.println("Please rerun and enter a positive integer");
		}
		input.close();
	}
}