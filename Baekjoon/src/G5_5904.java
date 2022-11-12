import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 2022.11.12
 * Moo 게임
 * 모르겠다!
 */
public class G5_5904 {
	public static int n;
	public static String result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		int num = 3; 
		int total = 10;
		int cnt = 0;
		String string = "3";
		int max = 3; 

		while(true) {
			if(total >= n) break;
			num = num * 2 + num + 1;
			total = num * 2 + num + 1;
			max++;
			string = string + Integer.toString(max) + string; 
			System.out.println(num);
			System.out.println(string.length());
//			System.out.println(string);
			System.out.println("-------------------");
			cnt++;
		}
		
		System.out.println(num);
		System.out.println(total);
		System.out.println(cnt);
//		System.out.println(string.length());
		
//		for(int i = 0, size = string.length()-1; i < size; i++) {
//			cnt += string.charAt(i) - '0';
//			if(cnt >= n+1) {
//				System.out.println("hello");
//				if(cnt == n) System.out.println("m");
//				else System.out.println("o");
//			}
//			
//			System.out.println(cnt);
//			
//		}
//		
//		System.out.println("hi");
		
	}
}
