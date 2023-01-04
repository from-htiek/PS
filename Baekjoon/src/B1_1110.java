import java.io.IOException;
import java.util.Scanner;

/*
 * 2023.01.04
 * 더하기 사이클
 */
public class B1_1110 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		int num = n; 
		
		while(true) {
			
			int sum = (num / 10) + (num % 10);
			num = (num % 10) * 10 + (sum % 10);
			
			result++;
			if(num == n) break;		

		}
		
		System.out.println(result);
	}
}
