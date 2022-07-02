import java.util.Scanner;

/*
 * 2022.07.02
 * 알람 시계
 */
public class B3_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		int hour, min;
		
		if(m - 45 >= 0) {
			hour = h;
			min = m - 45; 
		}else {
			hour = (h - 1 + 24) % 24; 
			min = m + 60 - 45; 
		}
		
		System.out.printf("%d %d", hour, min);
	}
}
