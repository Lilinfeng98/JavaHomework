package reverse;
import java.util.Random;

public class CountNum {

	public static void main(String[] args) {
		int CountNum[] = new int[10];      //������10��Ԫ�ص�δ��ʼ������ 
		Random r = new Random();
		
		for(int i=0; i<100; i++) {
			CountNum[r.nextInt(10)]++ ;    //δ��ʼ������Ԫ��ֵ��Ϊ0����ѭ��100�μ�¼0-9���ִ���
		}

		for(int j=0; j<10; j++) {
			System.out.println(j + "���ִ�����" + CountNum[j]);
		}
	}
}

