import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.04
 * 농작물 수확하기
 */
public class D3_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] farm = new int[n][n];
			int sum = 0;
			int start = n/2; // 마름모 첫줄 y위치

			// farm에 숫자 넣기
			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				for(int j = 0; j < n; j++) {
					farm[i][j] = str.charAt(j) - 48;
				}
			}

			// 농작물 가치 더하기
			// 마름모 윗부분 
			for(int i = 0; i <= n/2; i++) {
				// i = 0 일 때, 시작점으로부터 2*0+1 => 1칸 가치 더하기
				// i = 1 일 때, 시작점으로부터 2*1+1 => 3칸 가치 더하기
				for(int j = start; j < start+(2*i+1); j++) {
					sum += farm[i][j];
				}
				start -= 1;
			}
			
			// 마름모 윗부분 모두 계산 후 start = -1 => 0으로 만들기
			start += 1;
			
			// 마름모 아랫부분
			for(int i = n/2 + 1; i < n; i++) {
				start += 1;
				// n = 5 라면
				// i = 3 일 때, 시작점으로부터 5-2*1 => 3칸 가치 더하기
				// i = 4 일 때, 시작점으로부터 5-2*2 => 1칸 가치 더하기 
				for(int j = start; j < start + (n-2*start); j++) {
					sum += farm[i][j];
				}
				
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}
