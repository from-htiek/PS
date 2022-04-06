import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.04.06
 * 최장 증가 부분 수열
 * 문제에는 '같은' 숫자에 대한 처리를 수열을 증가하는 쪽으로 표현했지만, 
 * 내가 생각하는 LIS는 같은 숫자를 제외한 최장 길이가 맞는것같아 구현했더니 통과는 된다.
 * 이분탐색으로 구현하는 LIS도 나중에 구현해보도록하쟈 
 */
public class D3_3307 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] list = new int[n];
			int[] dp = new int[n]; // i번째 숫자를 포함한 최장 증가 부분 수열의 길이
			int max = 0; // 최장 부분 증가 수열의 길이
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 0; i < n; i++) {
				dp[i] = 1; // 숫자 하나는 최소 길이가 1인 부분 수열을 만들 수 있음
				for(int j = 0; j < i; j++) {
					if(list[i] > list[j] && dp[i] < dp[j]+1) {
						dp[i] = dp[j]+1;
					}
				}
				
				max = Math.max(max, dp[i]);
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			
		}
		
		System.out.println(sb.toString());
	}
}
