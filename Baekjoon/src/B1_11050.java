import java.util.Scanner;

/*
 * 2022.06.30
 * 이항 계수1
 */
public class B1_11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int result = 1; 
		for(int i = n; i > n-k; i--) {
			result *= i;
		}
		
		for(int i = k; i > 0; i--) {
			result /= i;
		}
		
		System.out.println(result);
	}
}
