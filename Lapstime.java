package assignment_3;

import java.util.Date;

public class Lapstime {
	
	public static void main(String[] args) {
		long lapstime = 10000;
		Date date = new Date();
		for(int i = 0; i <= 7; i++) {
			date.setTime(lapstime);
			System.out.println(lapstime + ":" + date.toString());
			lapstime *= 10;
		}
	}
}
