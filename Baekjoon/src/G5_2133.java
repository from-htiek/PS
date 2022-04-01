import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.04.01
 * 타일 채우기
 */
public class G5_2133 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+2];
		dp[2] = 3;
		
		for(int i = 4; i <= n; i+=2) {
			int num = 3; 
			for(int j = 2; j <= i; j +=2) {
				dp[i] += dp[i-j] * num;
				num = 2;
			}
			dp[i] += 2;
		}
		
		
		System.out.println(dp[n]);
	}
}
