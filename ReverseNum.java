package reverse;
import java.util.Scanner;

public class ReverseNum {

	public static void reverse(int number) {
		int NewNum = 0;
		while(number != 0)
		{
			NewNum = NewNum * 10 + number % 10;
			number /= 10;
		}
		
		System.out.println("The reversed number is " + NewNum);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter an integer:");
		int number = input.nextInt();
		reverse(number);
		input.close();
	}
}
