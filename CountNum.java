package reverse;
import java.util.Random;

public class CountNum {

	public static void main(String[] args) {
		int CountNum[] = new int[10];      //创建有10个元素的未初始化数组 
		Random r = new Random();
		
		for(int i=0; i<100; i++) {
			CountNum[r.nextInt(10)]++ ;    //未初始化数组元素值均为0，可循环100次记录0-9出现次数
		}

		for(int j=0; j<10; j++) {
			System.out.println(j + "出现次数是" + CountNum[j]);
		}
	}
}

