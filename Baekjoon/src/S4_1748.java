import java.io.IOException;
import java.util.Scanner;

/*
 * 2023.01.08
 * 수 이어 쓰기1
 */
public class S4_1748 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = -1;
		int result = 0;
		int num = n;
		
		while(num >= 10) {
			num = num / 10;
			cnt++;
			result += 9 * Math.pow(10, cnt) * (cnt+1);
		}
		

		result += (int) (n - Math.pow(10, cnt+1) + 1) * (cnt+2);
		System.out.println(result);
		
	}
}
