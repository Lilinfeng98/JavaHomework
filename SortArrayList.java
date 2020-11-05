package assignment_3;

import java.util.ArrayList;

public class SortArrayList {
	
	public static void sort(ArrayList<Number> list) {
		if(list.size() == 0 || list == null) {
			System.out.println("Invalid List!");   //���listΪ����ʾ��Ч����������
			return;
		}
		for(int i = 0; i < list.size()-1; i++) {
			Number MinNum = list.get(i);
			int MinIndex = i;
			for(int j = i+1; j < list.size(); j++) {
				if((int) list.get(j) < (int) MinNum) {
					MinNum = list.get(j);
					MinIndex = j;
				}                   
			}
			if(MinIndex != i) {
				list.set(MinIndex, list.get(i));
				list.set(i, MinNum);
			}          //�������i��Ԫ�ز�����С������С����Ԫ����iλ��Ԫ�ؽ���
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(11);
		list.add(10);
		list.add(15);
		list.add(3);
		
		sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
