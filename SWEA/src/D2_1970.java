import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.07.13
 * 쉬운 거스름돈
 */
public class D2_1970 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		int[] list = {50_000, 10_000, 5000, 1000, 500, 100, 50, 10};
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append("#").append(tc).append("\n");
			
			for(int i = 0; i < 8; i++) {
				sb.append(n / list[i]).append(" ");;
				n %= list[i];
			}
			
			sb.append("\n");

		}
		
		System.out.println(sb.toString());
	}
}
