package reverse;
import java.util.Scanner;

public class FindMin {
	
	public static int indexOfSmallestElement(int[] array) {
		int MinElem = array[0];
		int indexOfMin = 0;
		
		for (int i=1; i<array.length; i++) {
			if (array[i] < MinElem) {
				MinElem = array[i];
				indexOfMin = i;
			}
		}
		return indexOfMin;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter 10 integers:");
		int A[] = new int[10];
		
		for (int i=0; i<10; i++) {
			A[i] = input.nextInt();
		}
		
		System.out.println("The index of the smallest element is " + indexOfSmallestElement(A));
		System.out.println("The value of the smallest element is " + A[indexOfSmallestElement(A)]);
		
		input.close();
	}
}
